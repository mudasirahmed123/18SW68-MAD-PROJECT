package com.mudasir.coursemanagmentapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mudasir.coursemanagmentapp.adapter.DashboardAdapter;
import com.mudasir.coursemanagmentapp.model.DashboardModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DashboardModel> model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Course Dashboard");

        recyclerView=findViewById(R.id.main);

        model=new ArrayList<DashboardModel>();
        model.add(new DashboardModel(R.drawable.addd,"Add new Course"));
        model.add(new DashboardModel(R.drawable.course,"Show All Courses"));
        model.add(new DashboardModel(R.drawable.programming,"About Developer"));

        DashboardAdapter adapter=new DashboardAdapter(this,model);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}