package com.pucpr.medtime_ra2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;


import java.util.HashMap;
import java.util.Map;

public class Firebase_Registrar {

    public class Register extends AppCompatActivity {
        EditText mFullName,mEmail,mPassword;
        Button mRegisterBtn;
        TextView mLoginBtn;
        FirebaseAuth fAuth;

        String userID;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_create_user);

            mFullName   = findViewById(R.id.edTxt_cNome);
            mEmail      = findViewById(R.id.edTxt_cEmail);
            mPassword   = findViewById(R.id.edTxt_cSenha);
            mRegisterBtn= findViewById(R.id.btn_salvar_usuario);
            mLoginBtn   = findViewById(R.id.btn_entrar);

            fAuth = FirebaseAuth.getInstance();



            if(fAuth.getCurrentUser() != null){
                startActivity(new Intent(getApplicationContext(),Firebase_Main.class));
                finish();
            }


            mRegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String email = mEmail.getText().toString().trim();
                    String password = mPassword.getText().toString().trim();
                    final String fullName = mFullName.getText().toString();

                    if(TextUtils.isEmpty(email)){
                        mEmail.setError("O E-mail é necessário.");
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



                    // register the user in firebase

                    fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Register.this, "Conta criada.", Toast.LENGTH_SHORT).show();
                                userID = fAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("users").document(userID);
                                Map<String, Object> user = new HashMap<>();
                                user.put("fName",fullName);
                                user.put("email",email);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("TAG", "onSuccess: user Profile is created for "+ userID);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d("TAG", "onFailure: " + e.toString());
                                    }
                                });
                                startActivity(new Intent(getApplicationContext(),Firebase_Main.class));

                            }else {
                                Toast.makeText(Register.this, "Erro! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });

            mLoginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),Firebase_Entrar.class));
                }
            });

        }
    }



}
