package com.example.blooddonation.Adapter;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.R;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UrgentRequestAdapter extends RecyclerView.Adapter<UrgentRequestAdapter.UrgentViewHolder> {



    private Context context;


    private  JSONArray jsonArray;

    public UrgentRequestAdapter(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;

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



        CharSequence ago = null;

        try {

            String timeAgo = jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("timeFrame");

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");


            // calculating Time Ago from blood Time Frame
            try{
                long time = format.parse(timeAgo).getTime();
                long now = System.currentTimeMillis();
                ago = DateUtils.getRelativeTimeSpanString(time,now,DateUtils.DAY_IN_MILLIS);

            }catch (Exception e){
                e.printStackTrace();
            }

            holder.bloodGroup.setText(jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("requestedBloodGroup"));
            holder.relationShip.setText(jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("relationShipWithPatient"));
            holder.locationTV.setText(jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getJSONObject("location").getString("district"));
            holder.donationdayCountTV.setText(ago);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class UrgentViewHolder extends RecyclerView.ViewHolder{



        public TextView emergencyTV;
        public TextView bloodGroup;
        public TextView timeFrame,donationdayCountTV;
        public TextView relationShip;
        public TextView locationTV;

        public UrgentViewHolder(@NonNull View itemView) {
            super(itemView);

            emergencyTV = itemView.findViewById(R.id.emergencyTV);
            bloodGroup = itemView.findViewById(R.id.bloodGroup);
            relationShip = itemView.findViewById(R.id.relationShip);
            timeFrame = itemView.findViewById(R.id.timeFrame);
            locationTV = itemView.findViewById(R.id.locationTV);
            donationdayCountTV = itemView.findViewById(R.id.donationdayCountTV);


        }
    }
}
