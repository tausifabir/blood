package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.blooddonation.Adapter.DonationAdapter;
import com.example.blooddonation.Adapter.PostRequestAdapter;
import com.example.blooddonation.R;

import java.util.ArrayList;

public class PostRequestActivity extends AppCompatActivity {

     private RecyclerView recentHistoryRecyclerView;
     private PostRequestAdapter postRequestAdapter;

     private Spinner relativeSpinner,bloodGroupSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

        recentHistoryRecyclerView = findViewById(R.id.recentHistoryRecyclerView);

        relativeSpinner = findViewById(R.id.relativeSpinner);
        bloodGroupSpinner = findViewById(R.id.bloodGroupSpinner);


        String[] bloodGroupList = getResources().getStringArray(R.array.BloodGroup);
        String[] relativeList = getResources().getStringArray(R.array.Relative);



        ArrayAdapter<String> bloodSpinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,bloodGroupList);
        ArrayAdapter<String> relativeSpinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,relativeList);

        relativeSpinner.setAdapter(bloodSpinnerAdapter);
        bloodGroupSpinner.setAdapter(relativeSpinnerAdapter);




        ArrayList<String> fragmentTittle = new ArrayList<>();

        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");

        postRequestAdapter = new PostRequestAdapter(PostRequestActivity.this,fragmentTittle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PostRequestActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recentHistoryRecyclerView.setLayoutManager(linearLayoutManager);
        recentHistoryRecyclerView.setAdapter(postRequestAdapter);

        postRequestAdapter.notifyDataSetChanged();
    }
}