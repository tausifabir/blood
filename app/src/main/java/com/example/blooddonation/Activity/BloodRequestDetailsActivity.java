package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.blooddonation.R;

public class BloodRequestDetailsActivity extends AppCompatActivity {

    private TextView requesterNameShow,requestedBloodGroupShow, requestedHospitalShow , requestedTimeShow , requestedLocationShow, requestedMobileShow, requestedAlternateShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_request_details);

        requesterNameShow = findViewById(R.id.requesterNameShow);
        requestedBloodGroupShow = findViewById(R.id.requestedBloodGroupShow);
        requestedHospitalShow = findViewById(R.id.requestedHospitalShow);
        requestedTimeShow = findViewById(R.id.requestedTimeShow);
        requestedLocationShow = findViewById(R.id.requestedLocationShow);
        requestedMobileShow = findViewById(R.id.requestedMobileShow);
        requestedAlternateShow = findViewById(R.id.requestedAlternateShow);




        Intent intent = getIntent();
        String bloodRequesterName = intent.getStringExtra("bloodRequesterName");
        String requesterPhone = intent.getStringExtra("requesterPhone");
        String requesterAltPhone = intent.getStringExtra("requesterAltPhone");
        String requestedBlood = intent.getStringExtra("requestedBlood");
        String requestedLocation = intent.getStringExtra("requestedLocation");
        String timeFrame = intent.getStringExtra("timeFrame");



        String blood = requestedBlood;

        switch (blood){
            case "a_positive":
                requestedBloodGroupShow.setText("A+");
                break;
            case "b_positive":
                requestedBloodGroupShow.setText("B+");
                break;
            case "o_positive":
                requestedBloodGroupShow.setText("O+");
                break;
            case "ab_positive":
                requestedBloodGroupShow.setText("AB+");
                break;
            case "a_negative":
                requestedBloodGroupShow.setText("A-");
                break;
            case "b_negative":
                requestedBloodGroupShow.setText("B-");
                break;
            case "o_negative":
                requestedBloodGroupShow.setText("O-");
                break;
            default:
                requestedBloodGroupShow.setText("AB-");
                break;
        }

        requesterNameShow.setText(bloodRequesterName);
        requestedTimeShow.setText(timeFrame);
        requestedLocationShow.setText(requestedLocation);
        requestedMobileShow.setText(requesterPhone);
        requestedAlternateShow.setText(requesterAltPhone);
    }
}