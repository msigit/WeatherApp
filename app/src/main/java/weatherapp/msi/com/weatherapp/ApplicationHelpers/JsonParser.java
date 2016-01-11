package weatherapp.msi.com.weatherapp.ApplicationHelpers;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import weatherapp.msi.com.weatherapp.DataModels.WeatherDataModel;

/**
 * Created by MSi on 11/6/2015.
 */
public class JsonParser {

    public ArrayList<WeatherDataModel> jsonWeatherArrayList = new ArrayList<>();

    public static WeatherDataModel parseLocation(JSONObject response)
    {
        WeatherDataModel weatherDataModel = new WeatherDataModel();

        try
        {
            weatherDataModel.setUserCity(response.getString("city"));
            weatherDataModel.setUserCountryCode(response.getString("countryCode"));
        }
        catch (Exception  e)
        {
            e.printStackTrace();
            Log.e("Location Parsing Error", e.getMessage());
        }
        return  weatherDataModel;
    }


    public static WeatherDataModel parseWeather(JSONObject response)
    {
        WeatherDataModel weatherDataModel = new WeatherDataModel();

        try
        {
            JSONObject query = response.getJSONObject("query");
            JSONObject result = query.getJSONObject("results");
            JSONObject channel = result.getJSONObject("channel");
            JSONObject location = channel.getJSONObject("location");
            JSONObject wind = channel.getJSONObject("wind");
            JSONObject atmosphere = channel.getJSONObject("atmosphere");
            JSONObject astronomy = channel.getJSONObject("astronomy");
            JSONObject item = channel.getJSONObject("item");
            JSONObject condition = item.getJSONObject("condition");

            weatherDataModel.setLocationCity(location.getString("city"));
            weatherDataModel.setLocationCountry(location.getString("country"));
            weatherDataModel.setTodayWindChill(wind.getString("speed"));
            weatherDataModel.setTodayHumidity(atmosphere.getString("humidity"));
            weatherDataModel.setTodayAirpressure(atmosphere.getString("pressure"));
            weatherDataModel.setTodayVisibility(atmosphere.getString("visibility"));
            weatherDataModel.setTodaySunrise(astronomy.getString("sunrise"));
            weatherDataModel.setTodaySunset(astronomy.getString("sunset"));
            weatherDataModel.setTodayConditionCode(condition.getString("code"));
            weatherDataModel.setTodayTemp(condition.getString("temp"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Object Parsing Error", e.getMessage());
        }
        return weatherDataModel;
    }

    public ArrayList<WeatherDataModel> parseWeatherArrayData(JSONObject response)
    {
        try
        {
            JSONObject query = response.getJSONObject("query");
            JSONObject result = query.getJSONObject("results");
            JSONObject channel = result.getJSONObject("channel");
            JSONObject item = channel.getJSONObject("item");
            JSONArray forecast = item.getJSONArray("forecast");

            for(int i =0;i < forecast.length();i++)
            {
                JSONObject Forecast = forecast.getJSONObject(i);

                WeatherDataModel weatherDataModel = new WeatherDataModel();
                weatherDataModel.setForecastDay(Forecast.getString("day"));
                weatherDataModel.setForecastDate(Forecast.getString("date"));
                weatherDataModel.setForecastConditionCode(Forecast.getString("code"));
                weatherDataModel.setForecastHighTemp(Forecast.getString("high"));
                weatherDataModel.setForecastLowTemp(Forecast.getString("low"));

                jsonWeatherArrayList.add(weatherDataModel);
            }
            return jsonWeatherArrayList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Array Parsing Error", e.getMessage());
        }
        return jsonWeatherArrayList;
    }
}
