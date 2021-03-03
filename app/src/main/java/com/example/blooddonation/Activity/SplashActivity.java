package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.blooddonation.Fragment.SplashFragment_1;
import com.example.blooddonation.Fragment.SplashFragment_2;
import com.example.blooddonation.Fragment.SplashFragment_3;
import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

public class SplashActivity extends AppCompatActivity implements
        SplashFragment_1.SplashFragmentInterface1,
        SplashFragment_2.SplashFragmentInterface2 {

    private Button splashNextButton;

    private SharedPreference sharedPreference;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        sharedPreference = new SharedPreference(this);



        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SplashFragment_1 splashFragment_1 = new SplashFragment_1();
        fragmentTransaction.add(R.id.splashContainer,splashFragment_1);
        fragmentTransaction.commit();
        sharedPreference = new SharedPreference(this);

        if(sharedPreference.getSplashStatus()){
            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            finish();
        }


    }

    @Override
    public void replaceFirstFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SplashFragment_2 splashFragment_2 = new SplashFragment_2();
        fragmentTransaction.replace(R.id.splashContainer,splashFragment_2);
        fragmentTransaction.addToBackStack("null");
        fragmentTransaction.commit();

    }

    @Override
    public void replaceSecondFragment() {

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SplashFragment_3 splashFragment_3 = new SplashFragment_3();
        fragmentTransaction.replace(R.id.splashContainer,splashFragment_3);
        fragmentTransaction.addToBackStack("null");
        fragmentTransaction.commit();
    }
}