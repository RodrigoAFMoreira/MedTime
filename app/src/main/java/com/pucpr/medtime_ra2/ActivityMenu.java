package com.pucpr.medtime_ra2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ActivityMenu extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mRecyclerView = findViewById(R.id.recyclerView);
        myAdapter.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new Adapter(this, getMyList());

    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("Medicamento");
        m.setDescription("descricao");

    }
}