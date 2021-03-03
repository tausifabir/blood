package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

public class SplashActivity3 extends AppCompatActivity {


    private Button splashJourneyButton;

    private SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);


        splashJourneyButton = findViewById(R.id.splashJourneyBtn);

        sharedPreference = new SharedPreference(this);

        splashJourneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity3.this, LoginActivity.class));
                sharedPreference.setSplashStatus(true);
                finish();
            }
        });




    }
}