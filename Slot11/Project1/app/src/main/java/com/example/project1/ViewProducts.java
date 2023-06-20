package com.example.project1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewProducts extends AppCompatActivity {
    private ArrayList<ProductModal> productsModalArrayList;
    private DBHandler dbHandler;
    private ProductRVAdapter productRVAdapter;
    private RecyclerView coursesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);
        //Initializing our all variables.
        productsModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewProducts.this);
        //Getting our course array list from db handler class
        productsModalArrayList = dbHandler.getAllProducts();
        productRVAdapter = new ProductRVAdapter(productsModalArrayList, ViewProducts.this);
        //Creating recycler view
        coursesRV = findViewById(R.id.idRVProducts);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewProducts.this, RecyclerView.VERTICAL,
                false);
        coursesRV.setLayoutManager(linearLayoutManager);
        coursesRV.setAdapter(productRVAdapter);
    }
}