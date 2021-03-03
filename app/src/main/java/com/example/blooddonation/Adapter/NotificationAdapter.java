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

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {



    private Context context;

    private ArrayList<String> fragmentTittle;

    public NotificationAdapter(Context context, ArrayList<String> fragmentTittle) {
        this.context = context;
        this.fragmentTittle = fragmentTittle;

    }


    @NonNull
    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_row,parent,false);

        return new NotificationAdapter.NotificationViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return fragmentTittle.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{



        public TextView emergencyTV;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);

            emergencyTV = itemView.findViewById(R.id.emergencyTV);


        }
    }
}
