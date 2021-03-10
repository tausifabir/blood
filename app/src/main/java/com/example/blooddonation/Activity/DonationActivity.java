package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.blooddonation.Adapter.DonationAdapter;
import com.example.blooddonation.Adapter.ReviewAdapter;
import com.example.blooddonation.R;

import java.util.ArrayList;

public class DonationActivity extends AppCompatActivity {

    private RecyclerView donationHistoryRecyclerViews;
    private RecyclerView reviewRecyclerView;

    DonationAdapter donationAdapter;
    ReviewAdapter reviewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        donationHistoryRecyclerViews = findViewById(R.id.donationHistoryRecyclerViews);
        reviewRecyclerView = findViewById(R.id.reviewRecyclerView);

        ArrayList<String> fragmentTittle = new ArrayList<>();

        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");

        donationAdapter = new DonationAdapter(DonationActivity.this,fragmentTittle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DonationActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        donationHistoryRecyclerViews.setLayoutManager(linearLayoutManager);
        donationHistoryRecyclerViews.setAdapter(donationAdapter);
        donationAdapter.notifyDataSetChanged();

        reviewAdapter = new ReviewAdapter(DonationActivity.this,fragmentTittle);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(DonationActivity.this);
        reviewRecyclerView.setLayoutManager(linearLayoutManager2);
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);
        reviewRecyclerView.setAdapter(reviewAdapter);
        reviewAdapter.notifyDataSetChanged();
    }
}