package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends
        RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<Course> courseModalArrayList;
    private Context context;

    // constructor
    public CourseRVAdapter(ArrayList<Course>
                                   courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                 parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int
            position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Course modal = courseModalArrayList.get(position);
        holder.tvCourseName.setText(modal.getCourseName());
        holder.tvCourseDesc.setText(modal.getCourseDescription());

        holder.tvCourseDuration.setText(modal.getCourseDuration());
        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new
                                                   View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View v) {
                                                           //Update, delete
                                                       }
                                                   });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private TextView tvCourseName, tvCourseDesc,
                tvCourseDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            tvCourseName =
                    itemView.findViewById(R.id.tvCourseName);
            tvCourseDesc =
                    itemView.findViewById(R.id.tvCourseDescription);
            tvCourseDuration =
                    itemView.findViewById(R.id.tvCourseDuration);
        }
    }
}