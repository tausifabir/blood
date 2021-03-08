package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

public class SignUpActivity4 extends AppCompatActivity {

    private Button signUpNextBtn;

    private SharedPreference sharedPreference;


    private LinearLayout moreWeightLayout,lessWeightLayout;

    private TextView moreFiftyTV,moreFiftyIndicatorTV,lessFortyTV,lessFortyIndicatorTV;


    private int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);


        sharedPreference = new SharedPreference(this);



        moreFiftyTV = findViewById(R.id.moreFiftyTV);
        lessFortyTV = findViewById(R.id.lessFortyTV);
        moreFiftyIndicatorTV = findViewById(R.id.moreFiftyIndicatorTV);
        lessFortyIndicatorTV = findViewById(R.id.lessFortyIndicatorTV);


        moreWeightLayout = findViewById(R.id.moreWeightLayout);
        lessWeightLayout = findViewById(R.id.lessWeightLayout);





        signUpNextBtn = findViewById(R.id.signUpNextBtn);




        moreWeightLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                weight = 80;
                sharedPreference.saveWeight(weight);
                moreFiftyTV.setTextColor(getColor(R.color.white));
                moreFiftyIndicatorTV.setTextColor(getColor(R.color.white));
                moreWeightLayout.setBackground(getDrawable(R.drawable.weight_select_shape));



                lessFortyTV.setTextColor(getColor(R.color.black));
                lessFortyIndicatorTV.setTextColor(getColor(R.color.black));
                lessWeightLayout.setBackground(getDrawable(R.drawable.weight_shape));

            }
        });


        lessWeightLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                weight = 40;
                sharedPreference.saveWeight(weight);
                lessFortyTV.setTextColor(getColor(R.color.white));
                lessFortyIndicatorTV.setTextColor(getColor(R.color.white));
                lessWeightLayout.setBackground(getDrawable(R.drawable.weight_select_shape));



                moreFiftyTV.setTextColor(getColor(R.color.black));
                moreFiftyIndicatorTV.setTextColor(getColor(R.color.black));
                moreWeightLayout.setBackground(getDrawable(R.drawable.weight_shape));
            }
        });
        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity4.this,SignUpActivity5.class));
            }
        });
    }
}