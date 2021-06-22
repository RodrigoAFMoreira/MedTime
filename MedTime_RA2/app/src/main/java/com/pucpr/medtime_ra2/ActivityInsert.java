/*package com.pucpr.medtime_ra2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ActivityInsert extends AppCompatActivity {
    EditText txt_insert_nome;
    EditText txt_insert_endereco;
    EditText txt_telefone;
    Spinner txt_tipo;
    ArrayList<String> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        txt_insert_nome = findViewById(R.id.txt_insert_nome_med);
        txt_insert_endereco = findViewById(R.id.txt_insert_data);
        txt_telefone = findViewById(R.id.txt_info_extra);
        //Spinner//
        txt_tipo = findViewById(R.id.txt_tipo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lista_tipo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txt_tipo.setAdapter(adapter);
        //Spinner//
    }

    public void btn_salvar_insert(View view){
        String nome = txt_insert_nome.getText().toString();
        String endereco = txt_insert_endereco.getText().toString();
        String telefone = txt_telefone.getText().toString();
        String tipo = txt_tipo.getSelectedItem().toString();
        lista.add("Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nTipo: " + tipo);
        updateListView();
        Intent intent = new Intent(ActivityInsert.this, ActivityListView.class);
        startActivity(intent);
    }
    void updateListView(){
        saveListaToFile(ActivityInsert.this);
    }
    void saveListaToFile(Context context){
        try {
            OutputStream stream = ActivityInsert.this.openFileOutput(
                    "lista.txt",
                    MODE_PRIVATE
            );
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            for(int i=0; i<lista.size(); i++){
                writer.write(lista.get(i));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
            stream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}*/