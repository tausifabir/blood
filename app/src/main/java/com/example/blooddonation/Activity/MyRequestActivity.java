package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.blooddonation.Adapter.MyRequestAdapter;
import com.example.blooddonation.Adapter.UrgentRequestAdapter;
import com.example.blooddonation.R;

import java.util.ArrayList;

public class MyRequestActivity extends AppCompatActivity {

    private RecyclerView requestRecyclerview;

    private MyRequestAdapter myRequestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);


        requestRecyclerview = findViewById(R.id.requestRecyclerview);


        ArrayList<String> fragmentTittle = new ArrayList<>();
        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");

        myRequestAdapter = new MyRequestAdapter(MyRequestActivity.this,fragmentTittle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyRequestActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        requestRecyclerview.setLayoutManager(linearLayoutManager);
        requestRecyclerview.setAdapter(myRequestAdapter);

        myRequestAdapter.notifyDataSetChanged();
    }
}