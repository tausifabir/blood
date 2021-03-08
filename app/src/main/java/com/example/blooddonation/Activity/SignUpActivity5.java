package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

import org.w3c.dom.Text;

public class SignUpActivity5 extends AppCompatActivity {

    private Button signUpNextBtn;

    private String gender;
    private SharedPreference sharedPreference;

    private LinearLayout maleLayout,femaleLayout;
    private TextView maleTV,femaleTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up5);


        sharedPreference = new SharedPreference(this);


        Log.e("TAG", "onCreate: "+sharedPreference.getWeight());

        maleLayout = findViewById(R.id.maleLayout);
        femaleLayout = findViewById(R.id.femaleLayout);
        maleTV = findViewById(R.id.maleTV);
        femaleTV = findViewById(R.id.femaleTV);

        maleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gender = "Male";
                sharedPreference.saveGender(gender);
                maleTV.setTextColor(getColor(R.color.white));
                maleLayout.setBackground(getDrawable(R.drawable.weight_select_shape));




                femaleTV.setTextColor(getColor(R.color.black));
                femaleLayout.setBackground(getDrawable(R.drawable.weight_shape));

            }
        });


        femaleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                gender = "Female";
                sharedPreference.saveGender(gender);

                femaleTV.setTextColor(getColor(R.color.white));

                femaleLayout.setBackground(getDrawable(R.drawable.weight_select_shape));



                maleTV.setTextColor(getColor(R.color.black));
                maleLayout.setBackground(getDrawable(R.drawable.weight_shape));
            }
        });


        signUpNextBtn = findViewById(R.id.signUpNextBtn);
        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity5.this,SignUpActivity6.class));
            }
        });
    }
}