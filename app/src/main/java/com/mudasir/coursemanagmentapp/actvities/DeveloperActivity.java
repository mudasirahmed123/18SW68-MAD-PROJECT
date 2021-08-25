package com.mudasir.coursemanagmentapp.actvities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mudasir.coursemanagmentapp.R;

public class DeveloperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("About Developer");
    }
}