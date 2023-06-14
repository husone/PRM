package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateCourse extends AppCompatActivity {
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button updateCourseBtn, deleteCourseBtn;
    private DBHandler dbHandler;
    String courseName, courseDesc, courseDuration, courseTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteCourseBtn = findViewById(R.id.idBtnDelete);
        //Initialing our dbhandler class.
        dbHandler = new DBHandler(UpdateCourse.this);
        //Getting data which we passed in our adapter class
        courseName = getIntent().getStringExtra("name");
        courseDesc = getIntent().getStringExtra("description");
        courseDuration = getIntent().getStringExtra("duration");
        courseTracks = getIntent().getStringExtra("tracks");
        //Setting data to edit text of our update activity
        courseNameEdt.setText(courseName);
        courseDescriptionEdt.setText(courseDesc);
        courseTracksEdt.setText(courseTracks);
        courseDurationEdt.setText(courseDuration);
        //Adding on click listener to update course button
        updateCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling a method to update our course
                dbHandler.updateCourse(courseName, courseNameEdt.getText().toString(), courseDescriptionEdt.getText().toString(), courseTracksEdt.getText().toString(), courseDurationEdt.getText().toString());
                Toast.makeText(UpdateCourse.this, "Course  Updated.. ", Toast.LENGTH_SHORT).show();
                //Launching our main activity.
                Intent i = new Intent(UpdateCourse.this, MainActivity.class);
                startActivity(i);
            }
        });
        deleteCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling a method to delete our course.
                dbHandler.deleteCourse(courseName);
                Toast.makeText(UpdateCourse.this, "Deleted the  course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateCourse.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}