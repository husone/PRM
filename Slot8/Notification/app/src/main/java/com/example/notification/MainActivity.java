package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button b1;
    private static final String CHANNEL_ID = "my_channel_01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
    }private void addNotification() {
        //Create a Notification Manager
        NotificationManager manager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        //Create a Notification Channel : >=Android 8.0 (API level 26)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Android Notification",
                    NotificationManager.IMPORTANCE_DEFAULT);

            manager.createNotificationChannel(notificationChannel);//Add Notification Channel to Notification Manager
        }
        //Set contents for Notification
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Notification Alert, Click Me")
                .setContentText("Hi, This is Android Notification Detail!")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Hi, This is Android Notification Detail!"))

                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        //Attach Actions
        Intent notificationIntent = new Intent(this, Notification.class);//Open NotificationView Activity
        PendingIntent contentIntent =
                PendingIntent.getActivity(this, 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        //Delivering notifications
        manager.notify(0, builder.build());
    }
}