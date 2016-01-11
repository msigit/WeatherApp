package weatherapp.msi.com.weatherapp.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import weatherapp.msi.com.weatherapp.ApplicationHelpers.StaticService;
import weatherapp.msi.com.weatherapp.DataModels.WeatherDataModel;
import weatherapp.msi.com.weatherapp.R;

/**
 * Created by MSi on 11/10/2015.
 */
public class ForecastAdapter extends BaseAdapter {

    private Context context;
    private List<WeatherDataModel> weatherDataModelList;
    private String forecast_Location;
    private LayoutInflater inflater;
    private View forecastView,forecastLocation;
    private TextView forecast_day,forecast_date,forecast_high,forecast_low,forecast_location;
    private ImageView forecast_Condition;
    private boolean temp_settings;


    public ForecastAdapter(Context context, List<WeatherDataModel> weatherDataModelList,String forecast_Location,boolean temp_settings) {
        this.context = context;
        this.weatherDataModelList = weatherDataModelList;
        this.forecast_Location = forecast_Location;
        this.temp_settings = temp_settings;
    }


    @Override
    public int getCount() {
        return weatherDataModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherDataModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = LayoutInflater.from(context);

        WeatherDataModel weatherData = weatherDataModelList.get(position);

        if(position == 0)
        {
            forecastLocation = inflater.inflate(R.layout.forecast_location,null,true);
            forecast_location = (TextView) forecastLocation.findViewById(R.id.forecast_location);
            forecast_location.setText(forecast_Location);

            return forecastLocation;
        }
        else
        {
            forecastView = inflater.inflate(R.layout.forecast_weather, null, true);
            forecast_day = (TextView) forecastView.findViewById(R.id.forecast_day);
            forecast_date = (TextView) forecastView.findViewById(R.id.forecast_date);
            forecast_high = (TextView) forecastView.findViewById(R.id.forecast_high);
            forecast_low = (TextView) forecastView.findViewById(R.id.forecast_low);
            forecast_Condition = (ImageView) forecastView.findViewById(R.id.forecast_condition);

            forecast_day.setText(StaticService.Day(weatherData.getForecastDay()));
            forecast_date.setText(weatherData.getForecastDate());

            if (temp_settings) forecast_high.setText(weatherData.getForecastHighTemp()+"\u2109");
            else forecast_high.setText((Integer.parseInt(weatherData.getForecastHighTemp())- 32) * 5 / 9 +"\u2103");

            if (temp_settings) forecast_low.setText(weatherData.getForecastLowTemp()+"\u2109");
            else forecast_low.setText((Integer.parseInt(weatherData.getForecastLowTemp())- 32) * 5 / 9 +"\u2103");


//            forecast_high.setText(weatherData.getForecastHighTemp());
//            forecast_low.setText(weatherData.getForecastLowTemp());

            Picasso.with(context).load(StaticService.Condition64Img(weatherData.getForecastConditionCode())).into(forecast_Condition);

            return forecastView;
        }
    }
}
