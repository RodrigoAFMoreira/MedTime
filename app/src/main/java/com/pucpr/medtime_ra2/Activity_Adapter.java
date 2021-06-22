package com.pucpr.medtime_ra2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Activity_Adapter extends RecyclerView.Adapter<Activity_MyHolder> {

    Context c;
    ArrayList<Activity_Model> activityModels;

    public Activity_Adapter(Context c, ArrayList<Activity_Model> activityModels) {
        this.c = c;
        this.activityModels = activityModels;
    }

    @NonNull
    @Override
    public Activity_MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null);
        return new Activity_MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Activity_MyHolder activityMyHolder, int i) {

        activityMyHolder.mTitle.setText(activityModels.get(i).getTitle());
        activityMyHolder.mDes.setText(activityModels.get(i).getDescription());
        activityMyHolder.mImgeView.setImageResource(activityModels.get(i).getImg());

    }

    @Override
    public int getItemCount() {
        return activityModels.size();
    }
}
