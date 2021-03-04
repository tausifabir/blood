package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import com.example.blooddonation.R;


import org.jetbrains.annotations.NotNull;



public class LoginActivity extends AppCompatActivity {


    public  static final String baseUrl ="https://newsapi.org/";

    private Button loginBtn;
    private TextView signUp,forgotTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.signUpNextBtn);
        signUp = findViewById(R.id.signupBtn);
        forgotTV = findViewById(R.id.forgotTV);



        // First, create an `ApolloClient`
// Replace the serverUrl with your GraphQL endpoint









        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity1.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
        });
    }
}