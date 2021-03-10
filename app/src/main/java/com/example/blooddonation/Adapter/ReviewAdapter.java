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

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReViewViewHolder>  {



    private Context context;

    private ArrayList<String> fragmentTittle;

    public ReviewAdapter(Context context, ArrayList<String> fragmentTittle) {
        this.context = context;
        this.fragmentTittle = fragmentTittle;

    }


    @NonNull
    @Override
    public ReviewAdapter.ReViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_row,parent,false);

        return new ReviewAdapter.ReViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ReViewViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return fragmentTittle.size();
    }

    public class ReViewViewHolder extends RecyclerView.ViewHolder{



        public TextView hospitalNameTV;

        public ReViewViewHolder(@NonNull View itemView) {
            super(itemView);

            hospitalNameTV = itemView.findViewById(R.id.emergencyTV);


        }
    }
}
