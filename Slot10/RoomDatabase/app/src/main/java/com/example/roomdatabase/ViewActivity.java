package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
public class ViewActivity extends AppCompatActivity {
    private ArrayList<Course> courses;
    private CourseRVAdapter adapter;
    private RecyclerView rvCourses;
    CourseRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        // getting data
        res = new CourseRepository(getApplication());
        courses = new ArrayList<Course>();
        List<Course> data = res.getAll();
        for (int i = 0; i < data.size(); i++) {
            String name = data.get(i).getCourseName();
            String des = data.get(i).getCourseDescription();
            String dur = data.get(i).getCourseDuration();
            courses.add(new Course(name, des, dur));
        }
        //Passing array list to our adapter class
        adapter = new CourseRVAdapter(courses,
                ViewActivity.this);
        //Creating recycler view
        rvCourses = findViewById(R.id.rvCourses);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL,
                false);
        rvCourses.setLayoutManager(linearLayoutManager);
        rvCourses.setAdapter(adapter);//Setting our adapter to recycler view
    }
}