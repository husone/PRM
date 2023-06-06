package com.example.permission;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    private static final int PERMISSION_REQUEST_CODE = 200;
    private View view;
    private Button check_permission;
    private Button request_permission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check_permission = (Button)
                findViewById(R.id.check_permission);
        request_permission = (Button)
                findViewById(R.id.request_permission);
        check_permission.setOnClickListener(this);
        request_permission.setOnClickListener(this);
    }
    //Check permissions -> true/false
    private boolean checkPermission() {
        int result =
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION);
        int result1 =
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CAMERA);
        return ((result == PackageManager.PERMISSION_GRANTED) &&
                (result1 == PackageManager.PERMISSION_GRANTED));
    }
    //Request permissions
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
    }
    //Handling action for buttons
    @Override
    public void onClick(View v) {
        view = v;
        int id = v.getId();
        if (id == R.id.check_permission) {
            if (checkPermission()) {
                Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(view, "Please request permission.", Snackbar.LENGTH_LONG).show();
            }
        }
        if (id == R.id.request_permission) {
            if (!checkPermission()) {
                requestPermission();
            } else {
                Snackbar.make(view, "Permission already granted.", Snackbar.LENGTH_LONG).show();
            }
        }
    }
    //Result of request permissions
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,
                permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean locationAccepted = grantResults[0]
                            == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;
                    if (locationAccepted && cameraAccepted)
                        //Permission Granted
                        Snackbar.make(view, "Permission Granted, Now you can access location data and camera.",
                                Snackbar.LENGTH_LONG).show();
                    else {
                        //Permission Denied
                        Snackbar.make(view, "Permission Denied, You cannot access location data and camera.",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
}