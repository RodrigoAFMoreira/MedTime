package com.pucpr.medtime_ra2;

import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Usuario {
    private static Usuario instance = new Usuario();
    public ArrayList<SavedUser> savedUsers = new ArrayList<>();

    private Usuario(){}

    public ArrayList<SavedUser> getSavedUsers(){
        return this.savedUsers;
    }

    public void setSavedUsers(String nome, String senha){
        this.savedUsers.add(new SavedUser(nome,senha));
    }

    public static Usuario getInstance(){
        return instance;
    }

}