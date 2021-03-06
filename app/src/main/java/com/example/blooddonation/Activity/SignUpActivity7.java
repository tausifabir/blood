package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.blooddonation.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SignUpActivity7 extends AppCompatActivity {

    private Button birthDateBtn,signUpNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up7);

        birthDateBtn = findViewById(R.id.userRegisterEmailET);
        signUpNextBtn = findViewById(R.id.signUpNextBtn);

        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity7.this,SignUpActivity8.class));
            }
        });
    }

    public void selectBirthDate(View view) {

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, listner, year, month, day);
        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());// disable to take previous dates
        datePickerDialog.show();
    }



    private DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            final  Calendar calendar1 = Calendar.getInstance();
            calendar1.set(dayOfMonth,month,year);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy");
            String selectedDate = simpleDateFormat.format(calendar1.getTime());

            //birthDateBtn.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            birthDateBtn.setText(year+"/"+(month+1)+"/"+dayOfMonth);


        }
    };


    public DatePicker.OnDateChangedListener dateSetListener = new DatePicker.OnDateChangedListener() {
        public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
           // isDateChanged = true;
        }
    };
}