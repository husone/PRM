package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
public class ViewActivity extends AppCompatActivity {
    private ArrayList<Product> cours;
    private ProductRVAdapter adapter;
    private RecyclerView rvCourses;
    ProductRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        // getting data
        res = new ProductRepository(getApplication());
        cours = new ArrayList<Product>();
        List<Product> data = res.getAll();
        for (int i = 0; i < data.size(); i++) {
            Integer id = data.get(i).getId();
            String name = data.get(i).getName();
            String des = data.get(i).getDescription();
            Integer price = data.get(i).getPrice();
            Product p = new Product(name, des, price);
            p.setId(id);
            cours.add(p);
        }
        //Passing array list to our adapter class
        adapter = new ProductRVAdapter(cours,
                ViewActivity.this);
        //Creating recycler view
        rvCourses = findViewById(R.id.idRVProducts);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL,
                false);
        rvCourses.setLayoutManager(linearLayoutManager);
        rvCourses.setAdapter(adapter);//Setting our adapter to recycler view
    }
}