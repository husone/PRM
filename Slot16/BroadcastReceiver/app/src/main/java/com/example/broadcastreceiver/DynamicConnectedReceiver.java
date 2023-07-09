package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class DynamicConnectedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isWifiConnected(context.getApplicationContext())) {
            Toast.makeText(context, "Wifi is on",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Wifi is off",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isWifiConnected(Context context) {
        return
                Settings.System.getInt(context.getContentResolver(),
                        Settings.Global.WIFI_ON, 0) != 0;
    }
}