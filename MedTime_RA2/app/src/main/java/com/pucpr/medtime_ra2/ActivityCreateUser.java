package com.pucpr.medtime_ra2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ActivityCreateUser extends AppCompatActivity {
    EditText edTxt_cNome;
    EditText edTxt_cSenha;
    Button btn_salvar_usuario;
    ArrayList<String> users = new ArrayList<>();

}