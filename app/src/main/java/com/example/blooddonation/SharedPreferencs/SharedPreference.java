package com.example.blooddonation.SharedPreferencs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

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

    public void saveUser(String name,String passWord,String confirmPass){

        editor.putString("name",name);
        editor.putString("pass",passWord);
        editor.putString("confirmPassword",confirmPass);
        editor.commit();

    }

    public String getUser(){
        return sharedPreferences.getString("name",null);

    }

    public void setUserRegisterInfo(String name,String email,String password,String mobileNumber,String alternateMobileNumber,String socialLink,
                                    String bloodGroup,String weight,String gender,String religion,String district,String unionName,String postOffice,String policeStation,
                                    String dateOfBirth, String lastBloodDonationDate,String imageLink,long longitude,long latitude){

        editor.putString("status",name);
        editor.putString("email",email);
        editor.putString("password",password);
        editor.putString("mobileNumber",mobileNumber);
        editor.putString("alternateMobileNumber",alternateMobileNumber);
        editor.putString("socialLink",socialLink);
        editor.putString("bloodGroup",bloodGroup);
        editor.putString("religion",religion);
        editor.putString("district",district);
        editor.putString("unionName",unionName);
        editor.putString("postOffice",postOffice);
        editor.putString("policeStation",policeStation);
        editor.putString("dateOfBirth",dateOfBirth);
        editor.putString("lastBloodDonationDate",lastBloodDonationDate);
        editor.putString("imageLink",imageLink);
        editor.putLong("longitude",longitude);
        editor.putLong("latitude",latitude);
    }


    public HashMap<String, String> saveUserRegisterInfo() {
        HashMap<String, String> user = new HashMap<String, String>();


        return user;
    }


    public boolean getSplashStatus(){
        return sharedPreferences.getBoolean("status",false);
    }
}
