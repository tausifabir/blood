package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.blooddonation.Adapter.DonationAdapter;
import com.example.blooddonation.R;

import java.util.ArrayList;

public class DonationActivity extends AppCompatActivity {

    private RecyclerView donationRecyclerview;

    DonationAdapter donationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        donationRecyclerview = findViewById(R.id.donationRecyclerview);

        ArrayList<String> fragmentTittle = new ArrayList<>();

        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");

        donationAdapter = new DonationAdapter(DonationActivity.this,fragmentTittle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DonationActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        donationRecyclerview.setLayoutManager(linearLayoutManager);
        donationRecyclerview.setAdapter(donationAdapter);

        donationAdapter.notifyDataSetChanged();
    }
}