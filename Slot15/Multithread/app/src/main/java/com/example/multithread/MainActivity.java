package com.example.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    public String URL = "";
    EditText editText;
    Button button;
    ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edittxt);
        button = (Button) findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.image);

        editText.setText("https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg");
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        URL = editText.getText().toString();
                        new DownloadImage().execute(URL);//AsyncTask
                    }
                });
    }

    //DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void,
            Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {
            String imageURL = URL[0];
            Bitmap bitmap = null;
            try {
                //Download Image from URL
                InputStream input = new
                        java.net.URL(imageURL).openStream();
                //Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            //Set the bitmap into ImageView
            image.setImageBitmap(result);
        }
    }
}