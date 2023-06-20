package com.example.roomdatabase;

import android.app.Application;
import java.util.List;

public class CourseRepository {
    // below line is the create a variable
    // for dao and list for all courses.
    public static Dao dao;
    public CourseRepository(Application application) {
        CourseDatabase database =
                CourseDatabase.getInstance(application);
        dao = database.Dao();
    }
    // creating a method to insert the data to our database.
    public void insert(Course course) {
        dao.insert(course);
    }
    // creating a method to update data in database.
    public void update(Course course) {
        dao.update(course);
    }
    // creating a method to delete the data in our database.
    public void delete(Course course) {
        dao.delete(course);
    }
    // below is the method to delete all the courses.
    public void deleteAll() {
        dao.deleteAllCourses();
    }
    // below method is to read all the courses.
    public List<Course> getAll() {
        return dao.getAllCourses();
    }

}