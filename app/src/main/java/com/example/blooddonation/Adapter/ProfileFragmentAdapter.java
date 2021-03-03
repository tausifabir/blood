package com.example.blooddonation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.Activity.BadgesActivity;
import com.example.blooddonation.Activity.DonationActivity;
import com.example.blooddonation.Activity.InfoActivity;
import com.example.blooddonation.Activity.MyRequestActivity;
import com.example.blooddonation.Activity.PostRequestActivity;
import com.example.blooddonation.R;

import java.util.ArrayList;

public class ProfileFragmentAdapter extends RecyclerView.Adapter<ProfileFragmentAdapter.FragmentViewHolder> {

    private Context context;
    private ArrayList<String> fragmentTittle;

    public ProfileFragmentAdapter(Context context, ArrayList<String> fragmentTittle) {
        this.context = context;
        this.fragmentTittle = fragmentTittle;
    }



    @NonNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row,parent,false);

        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position) {

        //holder.fragmentName.setText(fragmentTittle.get(position));


        holder.fragmentName.setText(fragmentTittle.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {




                    if(holder.fragmentName.getText().toString().equals("Badges")){
                        Intent intent = new Intent(context, BadgesActivity.class);
                        context.startActivity(intent);
                    }else if(holder.fragmentName.getText().toString().equals("Donation")){
                        Intent intent = new Intent(context, DonationActivity.class);
                        context.startActivity(intent);

                    }else if(holder.fragmentName.getText().toString().equals("Request")){
                        Intent intent = new Intent(context, MyRequestActivity.class);
                        context.startActivity(intent);

                    }else if(holder.fragmentName.getText().toString().equals("Info")){
                        Intent intent = new Intent(context, InfoActivity.class);
                        context.startActivity(intent);

                    }else{
                        Intent intent = new Intent(context, PostRequestActivity.class);
                        context.startActivity(intent);
                    }
            }



        });
    }

    @Override
    public int getItemCount() {

        return fragmentTittle.size();
    }

    public class FragmentViewHolder extends RecyclerView.ViewHolder{


        TextView fragmentName;

        public FragmentViewHolder(@NonNull View itemView) {
            super(itemView);
            fragmentName = itemView.findViewById(R.id.fragmentName);


        }
    }
}

