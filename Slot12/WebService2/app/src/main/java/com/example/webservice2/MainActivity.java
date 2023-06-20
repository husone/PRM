package com.example.webservice2;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superListView = findViewById(R.id.superListView);
        getSuperHeroes();
    }

    private void getSuperHeroes() {
        Call<List<Results>> call =
                RetrofitClient.getInstance().getMyApi().getPosts();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call,
                                   Response<List<Results>> response) {
                List<Results> myPostList = response.body();
                ArrayList<Results> onePosts = new ArrayList<Results>(myPostList);
//                adapter = new ProductRVAdapter(cours,
//                        ViewActivity.this);
//                //Creating recycler view
//                rvCourses = findViewById(R.id.idRVProducts);
//                LinearLayoutManager linearLayoutManager = new
//                        LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL,
//                        false);
//                rvCourses.setLayoutManager(linearLayoutManager);
//                rvCourses.setAdapter(adapter);
                superListView.setAdapter(new
                        ArrayAdapter<Results>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, onePosts));
            }

            @Override
            public void onFailure(Call<List<Results>> call,
                                  Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occurred",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}