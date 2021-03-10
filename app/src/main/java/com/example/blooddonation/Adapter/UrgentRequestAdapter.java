package com.example.blooddonation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.Activity.BloodRequestDetailsActivity;
import com.example.blooddonation.Activity.LoginActivity;
import com.example.blooddonation.Activity.SignUpActivity1;
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

            //holder.bloodGroup.setText(jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("requestedBloodGroup"));


            // formating blood group
            String blood = jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("requestedBloodGroup");

            switch (blood){
                case "a_positive":
                    holder.bloodGroup.setText("A+");
                    break;
                case "b_positive":
                    holder.bloodGroup.setText("b+");
                    break;
                case "o_positive":
                    holder.bloodGroup.setText("O+");
                    break;
                case "ab_positive":
                    holder.bloodGroup.setText("AB+");
                    break;
                case "a_negative":
                    holder.bloodGroup.setText("A-");
                    break;
                case "b_negative":
                    holder.bloodGroup.setText("b-");
                    break;
                case "o_negative":
                    holder.bloodGroup.setText("O-");
                    break;
                default:
                    holder.bloodGroup.setText("AB-");
                    break;
            }

            holder.relationShip.setText(jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("relationShipWithPatient"));
            holder.locationTV.setText(jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getJSONObject("location").getString("district"));
            holder.donationdayCountTV.setText(ago);


            holder.urgentRowLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    context.startActivity(new Intent(context, BloodRequestDetailsActivity.class));
                }
            });

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

        public View urgentRowLayout;

        public UrgentViewHolder(@NonNull View itemView) {
            super(itemView);

            emergencyTV = itemView.findViewById(R.id.emergencyTV);
            bloodGroup = itemView.findViewById(R.id.bloodGroup);
            relationShip = itemView.findViewById(R.id.relationShip);
            timeFrame = itemView.findViewById(R.id.timeFrame);
            locationTV = itemView.findViewById(R.id.locationTV);
            donationdayCountTV = itemView.findViewById(R.id.donationdayCountTV);
            urgentRowLayout = itemView.findViewById(R.id.urgentRowLayout);


        }
    }
}
