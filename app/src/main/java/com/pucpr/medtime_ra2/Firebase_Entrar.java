package com.pucpr.medtime_ra2;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Firebase_Entrar extends AppCompatActivity {
    EditText mName,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mName = findViewById(R.id.edTxt_nome);
        mPassword = findViewById(R.id.edTxt_senha);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.btn_entrar);
        mCreateBtn = findViewById(R.id.btn_criar_conta);



        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = mName.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                if(TextUtils.isEmpty(name)){
                    mName.setError("O nome é necessário.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("A senha é necessária.");
                    return;
                }

                if(password.length() < 8){
                    mPassword.setError("Senha deve conter no mínimo 8 caracteres");
                    return;
                }


                // authenticate the user

                fAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Firebase_Entrar.this, "Logado com sucesso!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Firebase_Main.class));
                        }else {
                            Toast.makeText(Firebase_Entrar.this, "Erro! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Firebase_Registrar.Register.class));
            }
        });
    }
}
