/*package com.pucpr.medtime_ra2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {
    Button btn_adicionar;
    ListView list_view_item;
    ArrayList<String> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        list_view_item = findViewById(R.id.list_view_item);

        loadLista(ActivityListView.this);
    }

    protected void onResume() {
        super.onResume();
        btn_adicionar = findViewById(R.id.btn_adicionar);
        btn_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityListView.this, ActivityInsert.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityListView.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                lista
        );
        list_view_item.setAdapter(adapter);
    }

    void loadLista(Context context){
        try {
            InputStream stream = openFileInput("lista.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while((line = reader.readLine()) != null){
               lista.add(line);
            }
            reader.close();
            streamReader.close();
            stream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}*/