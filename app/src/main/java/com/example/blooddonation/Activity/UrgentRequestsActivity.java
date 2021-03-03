package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.blooddonation.Adapter.DonationAdapter;
import com.example.blooddonation.Adapter.UrgentRequestAdapter;
import com.example.blooddonation.R;

import java.util.ArrayList;

public class UrgentRequestsActivity extends AppCompatActivity {

    private UrgentRequestAdapter urgentRequestAdapter;

    private RecyclerView urgentRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_requests);


        urgentRecyclerview = findViewById(R.id.urgentRecyclerview);
        ArrayList<String> fragmentTittle = new ArrayList<>();

        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");

        urgentRequestAdapter = new UrgentRequestAdapter(UrgentRequestsActivity.this,fragmentTittle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UrgentRequestsActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        urgentRecyclerview.setLayoutManager(linearLayoutManager);
        urgentRecyclerview.setAdapter(urgentRequestAdapter);

        urgentRequestAdapter.notifyDataSetChanged();
    }
}