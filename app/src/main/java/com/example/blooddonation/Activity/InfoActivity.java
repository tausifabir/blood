package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.blooddonation.Adapter.InfoAdapter;
import com.example.blooddonation.Adapter.PostRequestAdapter;
import com.example.blooddonation.R;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {


    private RecyclerView infoBadgesRecyclerView;
    private InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        infoBadgesRecyclerView = findViewById(R.id.infoBadgesRecyclerView);



        ArrayList<String> fragmentTittle = new ArrayList<>();

        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");

        Integer[] imageId = {
                R.drawable.certificate,
                R.drawable.antibiotic,
                R.drawable.plant,
                R.drawable.ambulance,

        };

        infoAdapter = new InfoAdapter(InfoActivity.this,fragmentTittle,imageId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(InfoActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        infoBadgesRecyclerView.setLayoutManager(linearLayoutManager);
        infoBadgesRecyclerView.setAdapter(infoAdapter);

        infoAdapter.notifyDataSetChanged();



    }
}