package com.friendroid.artificialsofttest.Utills;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class ConnectionDetectorUtils {


    public static boolean NetworkCheck(Context context) {


        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        //If connectivity object is not null
        if (connectivity != null) {
            //Get network info - Mobile internet access
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (info != null) {
                //Look for whether device is currently connected to Mobile internet
                if (info.isConnected()) {
                    return true;
                }
            }
        }
        return false;

    }

    public static AlertDialog.Builder buildDialog(final Activity c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet connection.");
        builder.setMessage("Please check your internet connection!!!Turn internet on and come back");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                c.finish();
            }
        });

        return builder;
    }
}
