package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SignUpActivity9 extends AppCompatActivity {

    private Button bloodDonationBtn,signUpNextBtn;
    private SharedPreference sharedPreference;

    String donationDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up9);
        bloodDonationBtn = findViewById(R.id.bloodDonationBtn);
        signUpNextBtn = findViewById(R.id.signUpNextBtn);


        sharedPreference = new SharedPreference(this);

        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donationDate = bloodDonationBtn.getText().toString();
                sharedPreference.saveBirthDate(donationDate);
                startActivity(new Intent(SignUpActivity9.this,SignUpActivity8.class));
            }
        });
    }

    public void selectLastDonationDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, onDateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());// disable to take previous dates
        datePickerDialog.show();

    }
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            final  Calendar calendar1 = Calendar.getInstance();
            calendar1.set(dayOfMonth,month,year);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = simpleDateFormat.format(calendar1.getTime());


            String date = simpleDateFormat.format(new Date(year+"/"+(month+1)+"/"+dayOfMonth));

            //birthDateBtn.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            bloodDonationBtn.setText(date);


        }
    };


    public DatePicker.OnDateChangedListener dateSetListener = new DatePicker.OnDateChangedListener() {
        public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
            // isDateChanged = true;
        }
    };
}