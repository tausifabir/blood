package com.example.blooddonation.SharedPreferencs;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreference(Context context){
        sharedPreferences = context.getSharedPreferences("user_pref",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void setSplashStatus(boolean status){
        editor.putBoolean("status",status);
        editor.commit();

    }

    public boolean getSplashStatus(){
        return sharedPreferences.getBoolean("status",false);
    }
}
