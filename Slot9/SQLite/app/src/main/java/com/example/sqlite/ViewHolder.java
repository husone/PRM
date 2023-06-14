package com.example.sqlite;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    // creating variables for our text views.
    private TextView courseNameTV, courseDescTV,
            courseDurationTV, courseTracksTV;


    public TextView getCourseNameTV() {
        return courseNameTV;
    }

    public void setCourseNameTV(TextView courseNameTV) {
        this.courseNameTV = courseNameTV;
    }

    public TextView getCourseDescTV() {
        return courseDescTV;
    }

    public void setCourseDescTV(TextView courseDescTV) {
        this.courseDescTV = courseDescTV;
    }

    public TextView getCourseDurationTV() {
        return courseDurationTV;
    }

    public void setCourseDurationTV(TextView courseDurationTV) {
        this.courseDurationTV = courseDurationTV;
    }

    public TextView getCourseTracksTV() {
        return courseTracksTV;
    }

    public void setCourseTracksTV(TextView courseTracksTV) {
        this.courseTracksTV = courseTracksTV;
    }

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        // initializing our text views
        courseNameTV =
                itemView.findViewById(R.id.idTVCourseName);
        courseDescTV =
                itemView.findViewById(R.id.idTVCourseDescription);
        courseDurationTV =
                itemView.findViewById(R.id.idTVCourseDuration);
        courseTracksTV =
                itemView.findViewById(R.id.idTVCourseTracks);
    }
}
