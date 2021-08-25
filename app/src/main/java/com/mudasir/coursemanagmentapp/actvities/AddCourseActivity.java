package com.mudasir.coursemanagmentapp.actvities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.mudasir.coursemanagmentapp.R;
import com.mudasir.coursemanagmentapp.utils.DBHandler;

public class AddCourseActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText courseNameEdt, courseTeacherEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn, readCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse_activity);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Add new Course");


        // initializing all our variables.
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTeacherEdt = findViewById(R.id.idEdtCourseTeacher);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        readCourseBtn = findViewById(R.id.idBtnReadCourse);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(AddCourseActivity.this);

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String courseName = courseNameEdt.getText().toString();
                String courseTracks = courseTeacherEdt.getText().toString();
                String courseDuration = courseDurationEdt.getText().toString();
                String courseDescription = courseDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
                    Toast.makeText(AddCourseActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(courseName, courseDuration, courseDescription, courseTracks);

                // after adding the data we are displaying a toast message.
                Toast.makeText(AddCourseActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                courseNameEdt.setText("");
                courseDurationEdt.setText("");
                courseTeacherEdt.setText("");
                courseDescriptionEdt.setText("");
            }
        });

        readCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(AddCourseActivity.this, ShowCourse.class);
                startActivity(i);
            }
        });
    }
}