package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class MainActivity extends AppCompatActivity {
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    TextView name;
    TextView email;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        content = (TextView) findViewById(R.id.etContent);
    }

    private void writeData(File file, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(MainActivity.this, "Done" +
                    file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writePrivateData(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        //Creating folder
        File folder = getExternalFilesDir("External");
        //Creating file
        File file = new File(folder, "data.txt");
        //Writing data to file
        writeData(file, n + " - " + e);
        name.setText("");
        email.setText("");
    }

    private String readData(File myfile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myfile);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //Reading data from External File
    public void readPrivateData(View view) {
        content.setText("");
        //Folder name
        File folder = getExternalFilesDir("External");
        //File name
        File file = new File(folder, "data.txt");
        String data = readData(file);
        if (data != null) {
            content.setText(data);
        } else {
            content.setText("No Data Found");
        }
    }
}
