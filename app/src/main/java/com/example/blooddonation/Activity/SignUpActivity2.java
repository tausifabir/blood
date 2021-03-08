package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

public class SignUpActivity2 extends AppCompatActivity {

    private SharedPreference sharedPreference;

    private Button signUpNextBtn;

    private EditText userSocialET,userPhoneET,userAlPhoneET;

    private String userPhone,userAltPhone,userSocial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);


        sharedPreference = new SharedPreference(SignUpActivity2.this);


        userAlPhoneET = findViewById(R.id.userAlPhoneET);
        userPhoneET = findViewById(R.id.userPhoneET);
        userSocialET = findViewById(R.id.userSocialET);
        signUpNextBtn = findViewById(R.id.signUpNextBtn);

        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                userPhone = userPhoneET.getText().toString();
                userAltPhone = userAlPhoneET.getText().toString();
                userSocial = userSocialET.getText().toString();
                if(userPhone.length()>12 && userAlPhoneET.length()>12){

                    userAlPhoneET.setError("Phone number must be 8 character");
                    userPhoneET.setError("Phone number must be 8 character");
                }else{
                    sharedPreference.saveUserPhone(userPhone,userAltPhone,userSocial);
                    startActivity(new Intent(SignUpActivity2.this,SignUpActivity3.class));
                }

            }
        });
    }
}