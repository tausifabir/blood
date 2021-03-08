package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

public class SignUpActivity3 extends AppCompatActivity {

    private Button signUpNextBtn;
    private SharedPreference sharedPreference;

    private LinearLayout aPositive,bPositive,oPositive,abPositive;
    private LinearLayout aNegative,bNegative,oNegative,abNegative;

    private TextView bloodAPositive,bloodBPositive,bloodOPositive,bloodABPositive;
    private TextView bloodANegative,bloodBNegative,bloodONegative,bloodABNegative;

    private String bloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);


        //LinearLayout
        aPositive = findViewById(R.id.aPositive);
        bPositive = findViewById(R.id.bPositive);
        oPositive = findViewById(R.id.oPositive);
        abPositive = findViewById(R.id.abPositive);
        aNegative = findViewById(R.id.aNegative);
        bNegative = findViewById(R.id.bNegative);
        oNegative = findViewById(R.id.oNegative);
        abNegative = findViewById(R.id.abNegative);


        //TextView
        bloodAPositive = findViewById(R.id.bloodAPositive);
        bloodBPositive = findViewById(R.id.bloodBPositive);
        bloodOPositive = findViewById(R.id.bloodOPositive);
        bloodABPositive = findViewById(R.id.bloodABPositive);
        bloodANegative = findViewById(R.id.bloodANegative);
        bloodBNegative = findViewById(R.id.bloodBNegative);
        bloodONegative = findViewById(R.id.bloodONegative);
        bloodABNegative = findViewById(R.id.bloodABNegative);



        sharedPreference = new SharedPreference(this);

        signUpNextBtn = findViewById(R.id.signUpNextBtn);



        aPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bloodGroup = "A+";

                sharedPreference.saveBlood(bloodGroup);

                aPositive.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodAPositive.setTextColor(getColor(R.color.white));

                bPositive.setBackground(getDrawable(R.drawable.round_shape));
                oPositive.setBackground(getDrawable(R.drawable.round_shape));
                abPositive.setBackground(getDrawable(R.drawable.round_shape));
                aNegative.setBackground(getDrawable(R.drawable.round_shape));
                bNegative.setBackground(getDrawable(R.drawable.round_shape));
                oNegative.setBackground(getDrawable(R.drawable.round_shape));
                abNegative.setBackground(getDrawable(R.drawable.round_shape));





                bloodBPositive.setTextColor(getColor(R.color.Theme));
                bloodOPositive.setTextColor(getColor(R.color.Theme));
                bloodABPositive.setTextColor(getColor(R.color.Theme));
                bloodANegative.setTextColor(getColor(R.color.Theme));
                bloodBNegative.setTextColor(getColor(R.color.Theme));
                bloodONegative.setTextColor(getColor(R.color.Theme));
                bloodABNegative.setTextColor(getColor(R.color.Theme));





            }
        });


        bPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bloodGroup = "B+";
                sharedPreference.saveBlood(bloodGroup);

                bPositive.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodBPositive.setTextColor(getColor(R.color.white));


                aPositive.setBackground(getDrawable(R.drawable.round_shape));
                oPositive.setBackground(getDrawable(R.drawable.round_shape));
                abPositive.setBackground(getDrawable(R.drawable.round_shape));
                aNegative.setBackground(getDrawable(R.drawable.round_shape));
                bNegative.setBackground(getDrawable(R.drawable.round_shape));
                oNegative.setBackground(getDrawable(R.drawable.round_shape));
                abNegative.setBackground(getDrawable(R.drawable.round_shape));




                bloodAPositive.setTextColor(getColor(R.color.Theme));
                bloodOPositive.setTextColor(getColor(R.color.Theme));
                bloodABPositive.setTextColor(getColor(R.color.Theme));
                bloodANegative.setTextColor(getColor(R.color.Theme));
                bloodBNegative.setTextColor(getColor(R.color.Theme));
                bloodONegative.setTextColor(getColor(R.color.Theme));
                bloodABNegative.setTextColor(getColor(R.color.Theme));
            }
        });


        oPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bloodGroup = "O+";
                sharedPreference.saveBlood(bloodGroup);
                oPositive.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodOPositive.setTextColor(getColor(R.color.white));


                aPositive.setBackground(getDrawable(R.drawable.round_shape));
                bPositive.setBackground(getDrawable(R.drawable.round_shape));
                abPositive.setBackground(getDrawable(R.drawable.round_shape));
                aNegative.setBackground(getDrawable(R.drawable.round_shape));
                bNegative.setBackground(getDrawable(R.drawable.round_shape));
                oNegative.setBackground(getDrawable(R.drawable.round_shape));
                abNegative.setBackground(getDrawable(R.drawable.round_shape));




                bloodAPositive.setTextColor(getColor(R.color.Theme));
                bloodBPositive.setTextColor(getColor(R.color.Theme));
                bloodABPositive.setTextColor(getColor(R.color.Theme));
                bloodANegative.setTextColor(getColor(R.color.Theme));
                bloodBNegative.setTextColor(getColor(R.color.Theme));
                bloodONegative.setTextColor(getColor(R.color.Theme));
                bloodABNegative.setTextColor(getColor(R.color.Theme));
            }
        });


        abPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bloodGroup = "AB+";
                sharedPreference.saveBlood(bloodGroup);

                abPositive.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodABPositive.setTextColor(getColor(R.color.white));


                aPositive.setBackground(getDrawable(R.drawable.round_shape));
                oPositive.setBackground(getDrawable(R.drawable.round_shape));
                bPositive.setBackground(getDrawable(R.drawable.round_shape));
                aNegative.setBackground(getDrawable(R.drawable.round_shape));
                bNegative.setBackground(getDrawable(R.drawable.round_shape));
                oNegative.setBackground(getDrawable(R.drawable.round_shape));
                abNegative.setBackground(getDrawable(R.drawable.round_shape));




                bloodAPositive.setTextColor(getColor(R.color.Theme));
                bloodOPositive.setTextColor(getColor(R.color.Theme));
                bloodBPositive.setTextColor(getColor(R.color.Theme));
                bloodANegative.setTextColor(getColor(R.color.Theme));
                bloodBNegative.setTextColor(getColor(R.color.Theme));
                bloodONegative.setTextColor(getColor(R.color.Theme));
                bloodABNegative.setTextColor(getColor(R.color.Theme));
            }
        });



        bNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bloodGroup = "B-";
                sharedPreference.saveBlood(bloodGroup);
                bNegative.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodBNegative.setTextColor(getColor(R.color.white));



                aPositive.setBackground(getDrawable(R.drawable.round_shape));
                oPositive.setBackground(getDrawable(R.drawable.round_shape));
                bPositive.setBackground(getDrawable(R.drawable.round_shape));
                abPositive.setBackground(getDrawable(R.drawable.round_shape));
                aNegative.setBackground(getDrawable(R.drawable.round_shape));
                oNegative.setBackground(getDrawable(R.drawable.round_shape));
                abNegative.setBackground(getDrawable(R.drawable.round_shape));




                bloodAPositive.setTextColor(getColor(R.color.Theme));
                bloodOPositive.setTextColor(getColor(R.color.Theme));
                bloodBPositive.setTextColor(getColor(R.color.Theme));
                bloodANegative.setTextColor(getColor(R.color.Theme));
                bloodABPositive.setTextColor(getColor(R.color.Theme));
                bloodONegative.setTextColor(getColor(R.color.Theme));
                bloodABNegative.setTextColor(getColor(R.color.Theme));
            }
        });



        aNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bloodGroup = "A-";
                sharedPreference.saveBlood(bloodGroup);

                aNegative.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodANegative.setTextColor(getColor(R.color.white));


                aPositive.setBackground(getDrawable(R.drawable.round_shape));
                oPositive.setBackground(getDrawable(R.drawable.round_shape));
                bPositive.setBackground(getDrawable(R.drawable.round_shape));
                abPositive.setBackground(getDrawable(R.drawable.round_shape));
                bNegative.setBackground(getDrawable(R.drawable.round_shape));
                oNegative.setBackground(getDrawable(R.drawable.round_shape));
                abNegative.setBackground(getDrawable(R.drawable.round_shape));




                bloodAPositive.setTextColor(getColor(R.color.Theme));
                bloodOPositive.setTextColor(getColor(R.color.Theme));
                bloodBPositive.setTextColor(getColor(R.color.Theme));
                bloodABPositive.setTextColor(getColor(R.color.Theme));
                bloodBNegative.setTextColor(getColor(R.color.Theme));
                bloodONegative.setTextColor(getColor(R.color.Theme));
                bloodABNegative.setTextColor(getColor(R.color.Theme));
            }
        });

        oNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bloodGroup = "O-";
                sharedPreference.saveBlood(bloodGroup);

                oNegative.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodONegative.setTextColor(getColor(R.color.white));


                aPositive.setBackground(getDrawable(R.drawable.round_shape));
                oPositive.setBackground(getDrawable(R.drawable.round_shape));
                bPositive.setBackground(getDrawable(R.drawable.round_shape));
                abPositive.setBackground(getDrawable(R.drawable.round_shape));
                bNegative.setBackground(getDrawable(R.drawable.round_shape));
                aNegative.setBackground(getDrawable(R.drawable.round_shape));
                abNegative.setBackground(getDrawable(R.drawable.round_shape));




                bloodAPositive.setTextColor(getColor(R.color.Theme));
                bloodOPositive.setTextColor(getColor(R.color.Theme));
                bloodBPositive.setTextColor(getColor(R.color.Theme));
                bloodABPositive.setTextColor(getColor(R.color.Theme));
                bloodBNegative.setTextColor(getColor(R.color.Theme));
                bloodANegative.setTextColor(getColor(R.color.Theme));
                bloodABNegative.setTextColor(getColor(R.color.Theme));
            }
        });



        abNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bloodGroup = "AB-";
                sharedPreference.saveBlood(bloodGroup);

                abNegative.setBackground(getDrawable(R.drawable.selected_round_shape));
                bloodABNegative.setTextColor(getColor(R.color.white));


                aPositive.setBackground(getDrawable(R.drawable.round_shape));
                oPositive.setBackground(getDrawable(R.drawable.round_shape));
                bPositive.setBackground(getDrawable(R.drawable.round_shape));
                abPositive.setBackground(getDrawable(R.drawable.round_shape));
                bNegative.setBackground(getDrawable(R.drawable.round_shape));
                oNegative.setBackground(getDrawable(R.drawable.round_shape));
                aNegative.setBackground(getDrawable(R.drawable.round_shape));




                bloodAPositive.setTextColor(getColor(R.color.Theme));
                bloodOPositive.setTextColor(getColor(R.color.Theme));
                bloodBPositive.setTextColor(getColor(R.color.Theme));
                bloodABPositive.setTextColor(getColor(R.color.Theme));
                bloodBNegative.setTextColor(getColor(R.color.Theme));
                bloodONegative.setTextColor(getColor(R.color.Theme));
                bloodANegative.setTextColor(getColor(R.color.Theme));
            }
        });


        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity3.this,SignUpActivity4.class));
            }
        });


    }
}