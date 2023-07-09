package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity1 extends AppCompatActivity {
    DynamicConnectedReceiver dynamicConnectedReceiver = new
            DynamicConnectedReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(dynamicConnectedReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}