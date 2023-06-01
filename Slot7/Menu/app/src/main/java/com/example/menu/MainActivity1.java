package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity1 extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        TextView tv = (TextView) findViewById(R.id.tvShow);
        registerForContextMenu(tv);
    }
    //Create a Context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View
            v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }
    //Click an item in Context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
         if (itemId == R.id.context_edit)
                Toast.makeText(getApplicationContext(), "You clicked Edit menu", Toast.LENGTH_SHORT).show();
         if (itemId == R.id.context_share)
                Toast.makeText(getApplicationContext(), "You clicked Share menu", Toast.LENGTH_SHORT).show();
        return (super.onOptionsItemSelected(item));

    }
}