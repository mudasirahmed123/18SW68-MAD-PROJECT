package com.mudasir.coursemanagmentapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mudasir.coursemanagmentapp.R;
import com.mudasir.coursemanagmentapp.actvities.UpdateCourseActivity;
import com.mudasir.coursemanagmentapp.model.CourseModel;

import java.util.ArrayList;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<CourseModel> courseModalArrayList;
    private Context context;

    // constructor
    public CourseAdapter(ArrayList<CourseModel> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        CourseModel modal = courseModalArrayList.get(position);
        holder.courseNameTV.setText("Course Name: "+modal.getCourseName());
        holder.courseDurationTV.setText("Course Duration: "+modal.getCourseDuration());
        holder.courseTeacherTV.setText("Course Teacher: "+modal.getCourseTeacher());
        holder.courseDescTV.setText("Course Description:"+modal.getCourseDescription());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateCourseActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getCourseName());
                i.putExtra("description", modal.getCourseDescription());
                i.putExtra("duration", modal.getCourseDuration());
                i.putExtra("teacher", modal.getCourseTeacher());

                // starting our activity.
                context.startActivity(i);
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
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTeacherTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
            courseTeacherTV = itemView.findViewById(R.id.idTVCourseTeacher);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);

        }
    }
}