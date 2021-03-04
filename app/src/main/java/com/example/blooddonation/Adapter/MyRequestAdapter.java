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

public class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.MyRequestViewHolder>  {



    private Context context;

    private ArrayList<String> fragmentTittle;

    public MyRequestAdapter(Context context, ArrayList<String> fragmentTittle) {
        this.context = context;
        this.fragmentTittle = fragmentTittle;

    }


    @NonNull
    @Override
    public MyRequestAdapter.MyRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_row,parent,false);

        return new MyRequestAdapter.MyRequestViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyRequestAdapter.MyRequestViewHolder holder, int position) {





    }

    @Override
    public int getItemCount() {
        return fragmentTittle.size();
    }

    public class MyRequestViewHolder extends RecyclerView.ViewHolder{



        public TextView emergencyTV;

        public MyRequestViewHolder(@NonNull View itemView) {
            super(itemView);

            emergencyTV = itemView.findViewById(R.id.emergencyTV);


        }
    }
}
