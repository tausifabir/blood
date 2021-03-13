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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.Activity.BloodRequestDetailsActivity;
import com.example.blooddonation.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.MyRequestViewHolder>  {



    private Context context;

    private JSONArray jsonArray;


    public MyRequestAdapter(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;

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


            // formatting blood group
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
            holder.monthNameTV.setText(jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("timeFrame"));
            holder.donationDayCountTV.setText(ago);


            String bloodRequesterName =jsonArray.getJSONObject(position).getJSONObject("bloodRequester").getString("name");;
            String requesterPhone = jsonArray.getJSONObject(position).getJSONObject("bloodRequester").getString("mobileNumber");
            String requesterAltPhone = jsonArray.getJSONObject(position).getJSONObject("bloodRequester").getString("alternateMobileNumber");
            String requestedBlood = blood;
            String requestedLocation = jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getJSONObject("location").getString("district");
            String timeFrame = jsonArray.getJSONObject(position).getJSONObject("bloodRequest").getString("timeFrame");


            holder.urgentRowLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    context.startActivity(new Intent(context, BloodRequestDetailsActivity.class)
                            .putExtra("bloodRequesterName",bloodRequesterName)
                            .putExtra("requesterPhone",requesterPhone)
                            .putExtra("requesterAltPhone",requesterAltPhone)
                            .putExtra("requestedBlood",requestedBlood)
                            .putExtra("requestedLocation",requestedLocation)
                            .putExtra("timeFrame",timeFrame));
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

    public class MyRequestViewHolder extends RecyclerView.ViewHolder{



        public View scheduleLayout;


        public TextView emergencyTV;
        public TextView bloodGroup;
        public TextView timeFrame, donationDayCountTV;
        public TextView relationShip;
        public TextView locationTV;
        public TextView monthNameTV;

        public CardView urgentRowLayout;

        public MyRequestViewHolder(@NonNull View itemView) {
            super(itemView);

            emergencyTV = itemView.findViewById(R.id.emergencyTV);
            scheduleLayout = itemView.findViewById(R.id.scheduleLayout);
            emergencyTV = itemView.findViewById(R.id.emergencyTV);
            bloodGroup = itemView.findViewById(R.id.bloodGroup);
            relationShip = itemView.findViewById(R.id.relationShip);
            timeFrame = itemView.findViewById(R.id.timeFrame);
            locationTV = itemView.findViewById(R.id.locationTV);
            monthNameTV = itemView.findViewById(R.id.monthNameTV);
            donationDayCountTV = itemView.findViewById(R.id.donationdayCountTV);


        }
    }
}
