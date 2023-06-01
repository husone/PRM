package com.example.menu;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.message)
            Toast.makeText(getApplicationContext(), "You clicked Message menu", Toast.LENGTH_SHORT).show();
        if (itemId == R.id.picture)
            Toast.makeText(getApplicationContext(), "You clicked Picture menu", Toast.LENGTH_SHORT).show();
        if (itemId ==  R.id.mode)
            Toast.makeText(getApplicationContext(),"You clicked Mode menu",Toast.LENGTH_SHORT).show();
        if (itemId ==  R.id.option_favorites1)
        Toast.makeText(getApplicationContext(),"You clicked Music menu",Toast.LENGTH_SHORT).show();
        if (itemId == R.id.option_favorites2)
        Toast.makeText(getApplicationContext(),"You clicked Book menu",Toast.LENGTH_SHORT).show();
        if (itemId == R.id.about)
        Toast.makeText(getApplicationContext(),"You clicked About menu",Toast.LENGTH_SHORT).show();
        if (itemId == R.id.exit)
        finish();
        return super.onOptionsItemSelected(item);
    }
}