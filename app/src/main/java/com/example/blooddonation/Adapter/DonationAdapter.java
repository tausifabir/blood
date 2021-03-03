package com.example.blooddonation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.R;

import java.util.ArrayList;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.DonationViewHolder> {

    private Context context;

    private ArrayList<String> fragmentTittle;

    public DonationAdapter(Context context, ArrayList<String> fragmentTittle) {
        this.context = context;
        this.fragmentTittle = fragmentTittle;

    }


    @NonNull
    @Override
    public DonationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.donation_rows,parent,false);

        return new DonationAdapter.DonationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return fragmentTittle.size();
    }

    public class DonationViewHolder extends RecyclerView.ViewHolder{



        public TextView hospitalNameTV;

        public DonationViewHolder(@NonNull View itemView) {
            super(itemView);

            hospitalNameTV = itemView.findViewById(R.id.emergencyTV);


        }
    }
}
