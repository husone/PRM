package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        // Begin the transaction
        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.your_placeholder1, new fragmentOne());
        ft.replace(R.id.your_placeholder2, new fragmentTwo());
        // Complete the changes added above
        ft.commit();
    }
}
