package com.example.blooddonation.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.R;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder>  {





    private Context context;
    private final ArrayList<String> itemNames;
    private  Integer[] imageId;

    public InfoAdapter(Context context, ArrayList<String> itemNames,Integer[] imageId) {
        this.context = context;
        this.itemNames = itemNames;
        this.imageId = imageId;

    }


    @NonNull
    @Override
    public InfoAdapter.InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_row,parent,false);

        return new InfoAdapter.InfoViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.InfoViewHolder holder, int position) {


        holder.infoBadges.setImageResource(imageId[position]);



    }

    @Override
    public int getItemCount() {
        return itemNames.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{



        public ImageView infoBadges;

        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);

            infoBadges = itemView.findViewById(R.id.infoBadges);


        }
    }
}
