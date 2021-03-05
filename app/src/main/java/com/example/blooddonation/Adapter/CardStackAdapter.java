package com.example.blooddonation.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.R;

import java.util.ArrayList;
import java.util.List;


public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.CardViewHolder> {

    private Context context;
    private ArrayList<String> layoutList;

    public CardStackAdapter(Context context,  ArrayList<String> layoutList) {
        this.context = context;
        this.layoutList = layoutList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardstack_row,parent,false);



        return new CardStackAdapter.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        holder.textView.setText(layoutList.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return layoutList.size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder{


        TextView textView;

        public TextView emergencyTV;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);



        }
    }
}

