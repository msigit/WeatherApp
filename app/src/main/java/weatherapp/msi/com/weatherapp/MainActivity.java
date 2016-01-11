package weatherapp.msi.com.weatherapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

import weatherapp.msi.com.weatherapp.ApplicationHelpers.InternetChecker;
import weatherapp.msi.com.weatherapp.ApplicationHelpers.JsonParser;
import weatherapp.msi.com.weatherapp.ApplicationHelpers.StaticService;
import weatherapp.msi.com.weatherapp.DataModels.WeatherDataModel;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;

    TextView Temparature,Location,Date,Hightemp,Lowtemp,Humidity,Visibility,Airpressure,Wind,Sunrise,Sunset;
    Button forecastBtn;
    ImageView condition,settings,about;
    Toolbar toolbar;
    LinearLayout today_weather,internet_problem;
    private String ForecastLocation;

    SharedPreferences sharedPreferences;

    private String Shared_Name = "application_settings";
    private String pressure_settings = "precip_settings" ;
    private String temp_settings = "temp_settings" ;
    private String wind_settings = "wind_settings" ;
    private String distance_settings = "distance_settings";
    ArrayList <WeatherDataModel> weatherForecasts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        sharedPreferences = getSharedPreferences(Shared_Name,Context.MODE_PRIVATE);


        toolbar = (Toolbar) findViewById(R.id.today_forecast_toolbar);
        toolbar.setTitle("Weather Forecast");
        setSupportActionBar(toolbar);

        settings = (ImageView) findViewById(R.id.settings);
        about = (ImageView) findViewById(R.id.about);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(MainActivity.this,AppSettings.class);
                startActivityForResult(settingsIntent, 110);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(MainActivity.this,AppAbout.class);
                startActivity(aboutIntent);
            }
        });


        Temparature = (TextView) findViewById(R.id.temperature);
        Location = (TextView) findViewById(R.id.location);
        Date = (TextView) findViewById(R.id.date);
        Hightemp = (TextView) findViewById(R.id.todayHiTemp);
        Lowtemp = (TextView) findViewById(R.id.todayLoTemp);
        Humidity = (TextView) findViewById(R.id.todayHumidity);
        Visibility = (TextView) findViewById(R.id.todayVisibility);
        Airpressure = (TextView) findViewById(R.id.todayAirPressure);
        Wind = (TextView) findViewById(R.id.todayWind);
        Sunrise = (TextView) findViewById(R.id.todaySunrise);
        Sunset = (TextView) findViewById(R.id.todaySunset);
        forecastBtn = (Button) findViewById(R.id.forecastBtn);

        condition = (ImageView) findViewById(R.id.condition);
        today_weather = (LinearLayout) findViewById(R.id.today_weather);
        internet_problem = (LinearLayout) findViewById(R.id.reload);


        dialog = new ProgressDialog(this);
        dialog.setMessage("Updating weather data ...");
        dialog.setCancelable(false);


        internet_Check();

        internet_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                internet_Check();
            }
        });

        forecastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherForecast.class);
                intent.putExtra("ForecastArray", weatherForecasts);
                intent.putExtra("Location", ForecastLocation);
                startActivity(intent);
            }
        });
    }

    private void loadJsonData()
    {

        String URL = "http://ip-api.com/json";
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(URL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        WeatherDataModel model = JsonParser.parseLocation(response);
                        loadWeatherData(model.getUserCity(), model.getUserCountryCode());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Location Load error",error.getMessage());
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }


    private void loadWeatherData(String City,String CountryCode)
    {
        dialog.show();
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20" +
                "(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+City+"%2C%20"+CountryCode+"%22)&format=json" +
                "&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        final JsonObjectRequest jsonObject = new JsonObjectRequest(url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        final WeatherDataModel weatherData = JsonParser.parseWeather(response);
                        final ArrayList<WeatherDataModel> weatherArrayList = new JsonParser().parseWeatherArrayData(response);


                        ForecastLocation = weatherData.getLocationCity() + ", " + weatherData.getLocationCountry() + ".";
                        Picasso.with(MainActivity.this).load(StaticService.Condition64Img(weatherData.getTodayConditionCode())).resize(110,110).into(condition);

                        if (sharedPreferences.getBoolean(temp_settings, false)) Temparature.setText(weatherData.getTodayTemp()+"\u2109");
                        else Temparature.setText((Integer.parseInt(weatherData.getTodayTemp())- 32) * 5 / 9 +"\u2103");

                        Location.setText(weatherData.getLocationCity()+","+weatherData.getLocationCountry());
                        Date.setText(StaticService.Day(weatherArrayList.get(0).getForecastDay())+","+weatherArrayList.get(0).getForecastDate());

                        if (sharedPreferences.getBoolean(temp_settings, false)) Hightemp.setText(weatherArrayList.get(0).getForecastHighTemp()+"\u2109");
                        else Hightemp.setText((Integer.parseInt(weatherArrayList.get(0).getForecastHighTemp())- 32) * 5 / 9 +"\u2103");

                        if (sharedPreferences.getBoolean(temp_settings, false)) Lowtemp.setText(weatherArrayList.get(0).getForecastLowTemp()+"\u2109");
                        else Lowtemp.setText((Integer.parseInt(weatherArrayList.get(0).getForecastLowTemp())- 32) * 5 / 9 +"\u2103");

                        Humidity.setText(weatherData.getTodayHumidity()+"%");

                        if (sharedPreferences.getBoolean(distance_settings, false)) Visibility.setText(weatherData.getTodayVisibility()+" mi");
                        else Visibility.setText(String.format("%.0f",(Double.parseDouble(weatherData.getTodayVisibility())/ 0.621)) +" km");

                        if (sharedPreferences.getBoolean(pressure_settings, false)) Airpressure.setText(String.format("%.0f", (Double.parseDouble(weatherData.getTodayAirpressure()) * 25.4)) +" mmHg");
                        else Airpressure.setText(weatherData.getTodayAirpressure()+" inHg");

                        if (sharedPreferences.getBoolean(wind_settings, false)) Wind.setText(weatherData.getTodayWindChill()+" mph");
                        else Wind.setText(String.format("%.0f",(Integer.parseInt(weatherData.getTodayWindChill())/ 0.621)) +" km/h");

                        Sunrise.setText(weatherData.getTodaySunrise());
                        Sunset.setText(weatherData.getTodaySunset());
                        dialog.hide();

                        weatherForecasts = weatherArrayList;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Weather Load error",error.getMessage());
                    }
                });
        requestQueue.add(jsonObject);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        internet_Check();
        if(requestCode == 110)
        {
            loadJsonData();
        }
    }


    private void internet_Check()
    {
        InternetChecker internetChecker = new InternetChecker(MainActivity.this);

        if(!internetChecker.isInternetConnected())
        {
            internetChecker.showInternetAlert();
            today_weather.setVisibility(View.GONE);
            internet_problem.setVisibility(View.VISIBLE);
        }
        else
        {
            today_weather.setVisibility(View.VISIBLE);
            internet_problem.setVisibility(View.GONE);
            loadJsonData();
        }
    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id)
//        {
//            case R.id.about:
//            Intent aboutIntent = new Intent(MainActivity.this,AppAbout.class);
//            startActivity(aboutIntent);
//                break;
//
//            case R.id.settings:
//                Intent settingsIntent = new Intent(MainActivity.this,AppSettings.class);
//                startActivity(settingsIntent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

//        private void universalImageLoader(){
//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//            .showImageOnLoading(R.drawable.forecast_button)
//            .showImageOnFail(R.drawable.airpressure)
//            .cacheInMemory(true)
//            .cacheOnDisk(true)
//            .build();
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
//        ImageLoader.getInstance().init(config);
//    }

//    private void showImage(){
//        //ImageLoader.getInstance().displayImage("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg",imageView);
//
//    }
}
