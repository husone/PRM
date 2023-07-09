package com.example.service;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
public class MyService extends Service {
    MediaPlayer myPlayer;
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Successfully Created",
                Toast.LENGTH_LONG).show();
        myPlayer = MediaPlayer.create(this,R.raw.ctcht);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int
            startId) {
        Toast.makeText(this, "Service Started and Playing Music", Toast.LENGTH_LONG).show();
                myPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped and Music Stopped", Toast.LENGTH_LONG).show();
                myPlayer.stop();
    }
}