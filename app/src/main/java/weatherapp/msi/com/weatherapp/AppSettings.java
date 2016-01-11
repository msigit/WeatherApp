package weatherapp.msi.com.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by MSi on 11/11/2015.
 */
public class AppSettings extends AppCompatActivity
{
    private Toolbar toolbar;
    private Switch pressureSwitch,tempSwitch,windSwitch,distanceSwitch;
    private TextView pressureTxt,tempTxt,windTxt,distanceTxt;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private String Shared_Name = "application_settings";
    private String pressure_settings = "precip_settings" ;
    private String temp_settings = "temp_settings" ;
    private String wind_settings = "wind_settings" ;
    private String distance_settings = "distance_settings";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appsettings);

        toolbar = (Toolbar) findViewById(R.id.forecast_weather_toolbar);
        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pressureSwitch = (Switch) findViewById(R.id.pressure_switch);
        tempSwitch = (Switch) findViewById(R.id.temp_switch);
        windSwitch = (Switch) findViewById(R.id.wind_switch);
        distanceSwitch = (Switch) findViewById(R.id.distance_switch);
        pressureTxt = (TextView) findViewById(R.id.pressure_txt);
        tempTxt= (TextView) findViewById(R.id.temp_txt);
        windTxt= (TextView) findViewById(R.id.wind_txt);
        distanceTxt = (TextView) findViewById(R.id.distance_txt);

        sharedPreferences = getSharedPreferences(Shared_Name, Context.MODE_PRIVATE);

        pressureSwitch.setChecked(sharedPreferences.getBoolean(pressure_settings, false));
        if (sharedPreferences.getBoolean(pressure_settings, false)) pressureTxt.setText("milimeters");
        else pressureTxt.setText("inches");

        tempSwitch.setChecked(sharedPreferences.getBoolean(temp_settings, false));
        if (sharedPreferences.getBoolean(temp_settings, false)) tempTxt.setText("fahrenheit");
        else tempTxt.setText("celsius");

        windSwitch.setChecked(sharedPreferences.getBoolean(wind_settings, false));
        if (sharedPreferences.getBoolean(wind_settings, false)) windTxt.setText("miles per hour");
        else windTxt.setText("kilometers per hour");

        distanceSwitch.setChecked(sharedPreferences.getBoolean(distance_settings, false));
        if (sharedPreferences.getBoolean(distance_settings, false)) distanceTxt.setText("miles");
        else distanceTxt.setText("kilometers");


        pressureSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor = sharedPreferences.edit();
                if (isChecked) {
                    pressureTxt.setText("milimeters");
                    editor.putBoolean(pressure_settings, true);
                } else {
                    pressureTxt.setText("inches");
                    editor.putBoolean(pressure_settings, false);
                }
                editor.commit();
            }
        });


        tempSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor = sharedPreferences.edit();
                if (isChecked) {
                    tempTxt.setText("fahrenheit");
                    editor.putBoolean(temp_settings, true);
                } else {
                    tempTxt.setText("celsius");
                    editor.putBoolean(temp_settings, false);
                }
                editor.commit();
            }
        });

        windSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor = sharedPreferences.edit();
                if (isChecked) {
                    windTxt.setText("miles per hour");
                    editor.putBoolean(wind_settings, true);
                } else {
                    windTxt.setText("kilometers per hour");
                    editor.putBoolean(wind_settings, false);
                }
                editor.commit();
            }
        });


        distanceSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editor = sharedPreferences.edit();
                if (isChecked) {
                    distanceTxt.setText("miles");
                    editor.putBoolean(distance_settings, true);
                } else {
                    distanceTxt.setText("kilometers");
                    editor.putBoolean(distance_settings, false);
                }
                editor.commit();
            }
        });

    }
}
