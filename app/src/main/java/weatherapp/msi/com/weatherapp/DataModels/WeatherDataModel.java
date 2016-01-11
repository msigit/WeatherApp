package weatherapp.msi.com.weatherapp.DataModels;

import java.io.Serializable;

/**
 * Created by MSi on 11/5/2015.
 */
public class WeatherDataModel implements Serializable {

    private String UserCity;
    private String UserCountryCode;

    private String TodayHumidity;
    private String TodayVisibility;
    private String TodayAirpressure;
    private String TodayWindChill;
    private String TodaySunrise;
    private String TodaySunset;
    private String TodayConditionCode;
    private String TodayTemp;

    private String ForecastConditionCode;
    private String ForecastDate;
    private String ForecastDay;
    private String ForecastHighTemp;
    private String ForecastLowTemp;

    private String locationCity;
    private String LocationCountry;




    public String getUserCity() {
        return UserCity;
    }

    public void setUserCity(String userCity) {
        UserCity = userCity;
    }

    public String getUserCountryCode() {
        return UserCountryCode;
    }

    public void setUserCountryCode(String userCountryCode) {
        UserCountryCode = userCountryCode;
    }

    public String getTodayHumidity() {
        return TodayHumidity;
    }

    public void setTodayHumidity(String todayHumidity) {
        TodayHumidity = todayHumidity;
    }

    public String getTodayVisibility() {
        return TodayVisibility;
    }

    public void setTodayVisibility(String todayVisibility) {
        TodayVisibility = todayVisibility;
    }

    public String getTodayAirpressure() {
        return TodayAirpressure;
    }

    public void setTodayAirpressure(String todayAirpressure) {
        TodayAirpressure = todayAirpressure;
    }

    public String getTodaySunrise() {
        return TodaySunrise;
    }

    public void setTodaySunrise(String todaySunrise) {
        TodaySunrise = todaySunrise;
    }

    public String getTodaySunset() {
        return TodaySunset;
    }

    public void setTodaySunset(String todaySunset) {
        TodaySunset = todaySunset;
    }

    public String getTodayConditionCode() {
        return TodayConditionCode;
    }

    public void setTodayConditionCode(String todayConditionCode) {
        TodayConditionCode = todayConditionCode;
    }

    public String getForecastConditionCode() {
        return ForecastConditionCode;
    }

    public void setForecastConditionCode(String forecastConditionCode) {
        ForecastConditionCode = forecastConditionCode;
    }

    public String getForecastDate() {
        return ForecastDate;
    }

    public void setForecastDate(String forecastDate) {
        ForecastDate = forecastDate;
    }

    public String getForecastDay() {
        return ForecastDay;
    }

    public void setForecastDay(String forecastDay) {
        ForecastDay = forecastDay;
    }

    public String getForecastHighTemp() {
        return ForecastHighTemp;
    }

    public void setForecastHighTemp(String forecastHighTemp) {
        ForecastHighTemp = forecastHighTemp;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationCountry() {
        return LocationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        LocationCountry = locationCountry;
    }

    public String getTodayWindChill() {
        return TodayWindChill;
    }

    public void setTodayWindChill(String todayWindChill) {
        TodayWindChill = todayWindChill;
    }

    public String getForecastLowTemp() {
        return ForecastLowTemp;
    }

    public void setForecastLowTemp(String forecastLowTemp) {
        ForecastLowTemp = forecastLowTemp;
    }

    public String getTodayTemp() {
        return TodayTemp;
    }

    public void setTodayTemp(String todayTemp) {
        TodayTemp = todayTemp;
    }
}
