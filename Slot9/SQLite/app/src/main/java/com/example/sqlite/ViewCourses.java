package com.example.sqlite;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class ViewCourses extends AppCompatActivity {
    private ArrayList<CourseModal> courseModalArrayList;
    private DBHandler dbHandler;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);
        //Initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewCourses.this);
        //Getting our course array list from db handler class
        courseModalArrayList = dbHandler.readCourses();
        courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
        //Creating recycler view
        coursesRV = findViewById(R.id.idRVCourses);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL,
                false);
        coursesRV.setLayoutManager(linearLayoutManager);
        coursesRV.setAdapter(courseRVAdapter);
    }
}