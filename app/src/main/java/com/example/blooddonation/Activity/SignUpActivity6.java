package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

public class SignUpActivity6 extends AppCompatActivity {



    private Button signUpNextBtn;
    private SharedPreference sharedPreference;

    private EditText userDistrictET,userUnionET,userPostET,userPoliceET;
    private String district,union,postOffice,policeStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up6);

        signUpNextBtn = findViewById(R.id.signUpNextBtn);

        userDistrictET = findViewById(R.id.userDistrictET);
        userUnionET = findViewById(R.id.userUnionET);
        userPostET = findViewById(R.id.userPostET);
        userPoliceET = findViewById(R.id.userPoliceET);

        sharedPreference = new SharedPreference(this);


        Log.e("TAG", "onCreate: "+sharedPreference.getUserDetails().get(sharedPreference.KEY_GENDER) );

        signUpNextBtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                district = userDistrictET.getText().toString();
                union = userUnionET.getText().toString();
                postOffice = userPostET.getText().toString();
                policeStation = userPoliceET.getText().toString();

                sharedPreference.saveAddress(district,union,postOffice,policeStation);
                startActivity(new Intent(SignUpActivity6.this,SignUpActivity7.class));
            }
        });
    }
}