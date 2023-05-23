package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    public TextView editTextName;
    public Button btnClickMe;
    public Button btnDial;
    public EditText editTextURL;
    public Button btnURL;
    public static final String EXTRA_MESSAGE =
            "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        btnClickMe = (Button) findViewById(R.id.buttonClickMe);
        btnDial = (Button) findViewById(R.id.buttonDial);
        btnURL = (Button) findViewById(R.id.buttonURL);
        editTextURL = (EditText) findViewById(R.id.editTextURL);
        btnClickMe.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,
                                MainActivity2.class);
                        String
                                yName=editTextName.getText().toString();
                        intent.putExtra("MESSAGE", yName);
                        startActivity(intent);
                    }
                });
        btnDial.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Mở Activity quay số điện thoại
                        Intent intent = new
                                Intent(Intent.ACTION_DIAL);
                        startActivity(intent);
                    }
                });
        btnURL.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url=editTextURL.getText().toString();
                        Intent intent=new Intent(Intent.ACTION_VIEW,
                                Uri.parse(url));
                        startActivity(intent);
                    }
                });
    }
}
