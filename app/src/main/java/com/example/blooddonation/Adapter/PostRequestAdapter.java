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

public class PostRequestAdapter extends RecyclerView.Adapter<PostRequestAdapter.RecentHistoryViewHolder> {


    private Context context;

    private ArrayList<String> fragmentTittle;

    public PostRequestAdapter(Context context, ArrayList<String> fragmentTittle) {
        this.context = context;
        this.fragmentTittle = fragmentTittle;

    }


    @NonNull
    @Override
    public PostRequestAdapter.RecentHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recenthistory_row,parent,false);

        return new PostRequestAdapter.RecentHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostRequestAdapter.RecentHistoryViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return fragmentTittle.size();
    }

    public class RecentHistoryViewHolder extends RecyclerView.ViewHolder{



        public TextView hospitalNameTV;

        public RecentHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            hospitalNameTV = itemView.findViewById(R.id.emergencyTV);


        }
    }
}
