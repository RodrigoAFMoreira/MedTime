package com.pucpr.medtime_ra2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Activity_Menu extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Activity_Adapter myActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myActivityAdapter = new Activity_Adapter(this, getMyList());
        mRecyclerView.setAdapter(myActivityAdapter);

    }

    private ArrayList<Activity_Model> getMyList(){
        ArrayList<Activity_Model> activityModels = new ArrayList<>();

        Activity_Model m = new Activity_Model();
        m.setTitle("Add Medicamento");
        m.setDescription("Adicione o seu medicamento");
        m.setImg(R.drawable.plus);
        activityModels.add(m);

        m = new Activity_Model();
        m.setTitle("Calendário");
        m.setDescription("veja as datas no calendario");
        m.setImg(R.drawable.calendar);
        activityModels.add(m);

        m = new Activity_Model();
        m.setTitle("Sair");
        m.setDescription("sair da sessão");
        m.setImg(R.drawable.logout);
        activityModels.add(m);

        return activityModels;

    }
}