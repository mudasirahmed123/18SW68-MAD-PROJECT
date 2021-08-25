package com.mudasir.coursemanagmentapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mudasir.coursemanagmentapp.R;
import com.mudasir.coursemanagmentapp.actvities.AddCourseActivity;
import com.mudasir.coursemanagmentapp.actvities.DeveloperActivity;
import com.mudasir.coursemanagmentapp.actvities.ShowCourse;
import com.mudasir.coursemanagmentapp.model.DashboardModel;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.viewHolder> {

    Context context;
    ArrayList<DashboardModel> model;

    public DashboardAdapter(Context context, ArrayList<DashboardModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_layout, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DashboardModel dashModel = model.get(position);
        holder.img.setImageResource(dashModel.getImg());
        holder.text.setText(dashModel.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Toast.makeText(context, "Add new Course", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, AddCourseActivity.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        Toast.makeText(context, "Show All Courses", Toast.LENGTH_SHORT).show();
                        Intent  intent1=new Intent(context, ShowCourse.class);
                        context.startActivity(intent1);
                        break;

                    case 2:
                        Toast.makeText(context, "About Developer", Toast.LENGTH_SHORT).show();
                        Intent intent3=new Intent(context, DeveloperActivity.class);
                        context.startActivity(intent3);
                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView text;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
        }
    }
}
