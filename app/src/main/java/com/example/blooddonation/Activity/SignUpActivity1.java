package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

public class SignUpActivity1 extends AppCompatActivity {

    private SharedPreference sharedPreference;

    private Button signUpNextBtn;

    private EditText userRegisterPassET,userRegisterEmailET,userRegisterConfirmPassET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);


        sharedPreference = new SharedPreference(SignUpActivity1.this);


        signUpNextBtn = findViewById(R.id.signUpNextBtn);

        userRegisterEmailET = findViewById(R.id.userRegisterEmailET);
        userRegisterPassET = findViewById(R.id.userRegisterPassET);
        userRegisterConfirmPassET = findViewById(R.id.userRegisterConfirmPassET);

        String userConPass = userRegisterConfirmPassET.getText().toString();
        String userPass = userRegisterPassET.getText().toString();
        String userEmail = userRegisterEmailET.getText().toString();

        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity1.this,SignUpActivity2.class));
            }
        });
    }
}