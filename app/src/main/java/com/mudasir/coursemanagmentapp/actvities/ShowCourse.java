package com.mudasir.coursemanagmentapp.actvities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mudasir.coursemanagmentapp.R;
import com.mudasir.coursemanagmentapp.adapter.CourseAdapter;
import com.mudasir.coursemanagmentapp.model.CourseModel;
import com.mudasir.coursemanagmentapp.utils.DBHandler;

import java.util.ArrayList;

public class ShowCourse extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<CourseModel> courseModalArrayList;
    private DBHandler dbHandler;
    private CourseAdapter courseRVAdapter;
    private RecyclerView coursesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcourse);

        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ShowCourse.this);

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = new CourseAdapter(courseModalArrayList, ShowCourse.this);
        coursesRV = findViewById(R.id.idCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowCourse.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);
    }
}