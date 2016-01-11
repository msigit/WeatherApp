package weatherapp.msi.com.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import weatherapp.msi.com.weatherapp.Adapters.ForecastAdapter;
import weatherapp.msi.com.weatherapp.DataModels.WeatherDataModel;

/**
 * Created by MSi on 11/9/2015.
 */
public class WeatherForecast extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;

    private String Shared_Name = "application_settings";
    private String temp_settings = "temp_settings" ;
    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.forecast_weather_toolbar);
        toolbar.setTitle("Weather Forecast");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sharedPreferences = getSharedPreferences(Shared_Name, Context.MODE_PRIVATE);

        ArrayList <WeatherDataModel> weatherDataModels = (ArrayList <WeatherDataModel>)getIntent().getSerializableExtra("ForecastArray");

        listView = (ListView) findViewById(R.id.forecast_list);
        ForecastAdapter forecastAdapter = new ForecastAdapter(WeatherForecast.this,weatherDataModels,getIntent().getStringExtra("Location"),sharedPreferences.getBoolean(temp_settings, false));
        listView.setAdapter(forecastAdapter);
    }
}
