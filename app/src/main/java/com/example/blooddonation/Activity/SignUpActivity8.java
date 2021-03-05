package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.blooddonation.R;

public class SignUpActivity8 extends AppCompatActivity {

    private Button signUpNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up8);

        signUpNextBtn = findViewById(R.id.signUpNextBtn);

        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity8.this,HomeActivity.class));
            }
        });
    }

    public void uploadImage(View view) {
    }
}