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



    private String userPass,userConPass,userEmail;

    private EditText userRegisterPassET,userRegisterEmailET,userRegisterConfirmPassET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);


        sharedPreference = new SharedPreference(SignUpActivity1.this);


        signUpNextBtn = findViewById(R.id.signUpNextBtn);

        userRegisterEmailET = findViewById(R.id.userEmailET);
        userRegisterPassET = findViewById(R.id.userRegisterPassET);
        userRegisterConfirmPassET = findViewById(R.id.userRegisterConfirmPassET);


        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                userEmail = userRegisterEmailET.getText().toString();
                userPass = userRegisterPassET.getText().toString();
                userConPass = userRegisterConfirmPassET.getText().toString();


                if(userPass.length()>7 && userConPass.length()>7){
                    userRegisterPassET.setError("Pass must be 8 character");
                    userRegisterConfirmPassET.setError("Pass must be 8 character");

                }else{
                    sharedPreference.saveUserEmail(userEmail,userPass,userConPass);
                    startActivity(new Intent(SignUpActivity1.this,SignUpActivity2.class));
                }


            }
        });
    }
}