package com.example.blooddonation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.R;
import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.ArrayList;

public class UrgentRequestAdapter extends RecyclerView.Adapter<UrgentRequestAdapter.UrgentViewHolder> {



    private Context context;


    private  ArrayList<String> itemNames;

    public UrgentRequestAdapter(Context context, ArrayList<String> itemNames) {
        this.context = context;
        this.itemNames = itemNames;

    }


    @NonNull
    @Override
    public UrgentRequestAdapter.UrgentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.urgentrequest_row,parent,false);

        return new UrgentRequestAdapter.UrgentViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull UrgentRequestAdapter.UrgentViewHolder holder, int position) {





    }

    @Override
    public int getItemCount() {
        return itemNames.size();
    }

    public class UrgentViewHolder extends RecyclerView.ViewHolder{



        public TextView emergencyTV;

        public UrgentViewHolder(@NonNull View itemView) {
            super(itemView);

            emergencyTV = itemView.findViewById(R.id.emergencyTV);


        }
    }
}
