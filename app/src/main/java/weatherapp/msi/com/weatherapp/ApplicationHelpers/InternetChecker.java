package weatherapp.msi.com.weatherapp.ApplicationHelpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

import weatherapp.msi.com.weatherapp.R;

/**
 * Created by MSi on 11/5/2015.
 */
public class InternetChecker {

    private Context context;
    public InternetChecker(Context context) {
        this.context = context;
    }


    public boolean isInternetConnected()
    {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
        }
        return false;
    }


    public void showInternetAlert()
    {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);

        alertdialog.setTitle("Network Settings");
        alertdialog.setMessage("No network is available. Please check your internet settings");
        alertdialog.setIcon(R.drawable.wireless);
        //alertdialog.setCancelable(false);

        alertdialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                context.startActivity(intent);
            }
        });

        alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // alertdialog.show();
            }
        });

        alertdialog.show();
    }
}
