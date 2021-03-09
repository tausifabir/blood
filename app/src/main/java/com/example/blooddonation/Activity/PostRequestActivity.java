package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blooddonation.Adapter.DonationAdapter;
import com.example.blooddonation.Adapter.PostRequestAdapter;
import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PostRequestActivity extends AppCompatActivity {

     private RecyclerView recentHistoryRecyclerView;
     private PostRequestAdapter postRequestAdapter;

     private Spinner relativeSpinner,bloodGroupSpinner;
     public  static final String baseUrl ="http://192.168.1.230:8085/graphql/";

     private TextView scheduleTV;
     
     private EditText contactNumberET;
     private String contactPhone;

     private SharedPreference sharedPreference;
     private String bloodChanged;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

        recentHistoryRecyclerView = findViewById(R.id.recentHistoryRecyclerView);

        relativeSpinner = findViewById(R.id.relativeSpinner);
        bloodGroupSpinner = findViewById(R.id.bloodGroupSpinner);



        scheduleTV = findViewById(R.id.scheduleTV);
        contactNumberET = findViewById(R.id.contactNumberET);



        String[] bloodGroupList = getResources().getStringArray(R.array.BloodGroup);
        String[] relativeList = getResources().getStringArray(R.array.Relative);



        ArrayAdapter<String> bloodSpinnerAdapter = new ArrayAdapter(this,R.layout.simple_custom_dropdown_item,bloodGroupList);
        //bloodSpinnerAdapter.setDropDownViewResource(R.layout.simple_custom_dropdown_item);
        ArrayAdapter<String> relativeSpinnerAdapter = new ArrayAdapter(this,R.layout.simple_custom_dropdown_item,relativeList);

        relativeSpinner.setAdapter(relativeSpinnerAdapter);
        bloodGroupSpinner.setAdapter(bloodSpinnerAdapter);


        String relative = relativeSpinner.getSelectedItem().toString();


        ArrayList<String> fragmentTittle = new ArrayList<>();

        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");

        postRequestAdapter = new PostRequestAdapter(PostRequestActivity.this,fragmentTittle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PostRequestActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recentHistoryRecyclerView.setLayoutManager(linearLayoutManager);
        recentHistoryRecyclerView.setAdapter(postRequestAdapter);

        postRequestAdapter.notifyDataSetChanged();
    }

    public void postBloodRequest(View view) {



        SharedPreference sharedPreference = new SharedPreference(this);

        String relative = relativeSpinner.getSelectedItem().toString();
        String bloodGroup = bloodGroupSpinner.getSelectedItem().toString();
        String contactPhone = contactNumberET.getText().toString();


        if(bloodGroup.equals("A+")){
            bloodChanged =  "a_positive";
        }else if(bloodGroup.equals("A-")){
            bloodChanged =  "a_negative";
        }else if(bloodGroup.equals("B+")){
            bloodChanged =  "b_positive";
        }else if(bloodGroup.equals("B-")){
            bloodChanged =  "b_negative";
        }else if(bloodGroup.equals("O+")){
            bloodChanged =  "o_positive";
        }else if(bloodGroup.equals("O-")){
            bloodChanged =  "o_negative";
        }else if(bloodGroup.equals("AB+")){
            bloodChanged =  "ab_positive";
        }else{
            bloodChanged =  "ab_negative";
        }

        String relativeField =  "\""+relative+"\"";
        String blood =  "\""+bloodChanged+"\"";

        String email =  "\""+sharedPreference.getUserEmailLogin()+"\"";
        String district =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_DISTRICT)+"\"";
        String union =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_UNION)+"\"";
        String postoffice =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_POSTOFFICE)+"\"";
        String police =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_POLICE)+"\"";
        String timeDate = "\""+scheduleTV.getText().toString()+"\"";
        String phone = "\""+contactPhone+"\"";




        String bloodQueryTest = "mutation {\n" +
                "  takeBloodRequest(input: {\n" +
                "    userIdentityEmail: "+email+"\n" +
                "    location: {\n" +
                "      district: "+district+"\n" +
                "      unionName:"+union+"\n" +
                "      postOffice:"+postoffice+"\n" +
                "      policeStation:"+police+"\n" +
                "    }\n" +
                "    relationShipWithPatient:"+relativeField+"\n" +
                "    alternateMobileNumber:"+phone+"\n" +
                "    requestedBloodGroup:"+blood+"\n" +
                "    timeFrame:"+timeDate+"\n" +
                "  }){\n" +
                "    status\n" +
                "    code\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message \n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";


        String bloodQuery = "mutation {\n" +
                "  takeBloodRequest(input: {\n" +
                "    userIdentityEmail: \"abir5@gmail.com\"\n" +
                "    location: {\n" +
                "      district: \"comilla\"\n" +
                "      unionName:\"baksimul\"\n" +
                "      postOffice:\"burichong\"\n" +
                "      policeStation:\"burichogn\"\n" +
                "    }\n" +
                "    relationShipWithPatient:\"brother\"\n" +
                "    alternateMobileNumber:\"01679409720\"\n" +
                "    requestedBloodGroup:\"ab_positive\"\n" +
                "    timeFrame:\"2020-09-04T12:22\"\n" +
                "  }){\n" +
                "    status\n" +
                "    code\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message \n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";



        OkHttpClient okHttpClient = new OkHttpClient();
        
        
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("query",bloodQueryTest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        RequestBody requestBody = RequestBody.create(null,jsonObject.toString());
        Request request = new Request.Builder()
                .url(baseUrl)
                //.post(formBody)
                .post(requestBody)
                .build();


        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {

                Log.e("TAG", "onFailure: "+e.getLocalizedMessage() );


                Log.e("OkHTTP", "onResponse: "+baseUrl );
            }

            @Override
            public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {

                String res = response.body().string();
                if(response.isSuccessful()){


                    try {

                        JSONObject json = new JSONObject(res);

                        String code = json.getJSONObject("data").getJSONObject("registerUser").getString("code");

                        int codeRequest = Integer.parseInt(code);


                        Log.e("response", "onResponse: "+res);
                        Log.e("Initial Query", "onResponse: "+bloodQueryTest);
                        if(codeRequest == 200){


                            
                            PostRequestActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(PostRequestActivity.this, "Request has posted successfully", Toast.LENGTH_SHORT).show();
                                }
                            });

                            //String token = json.getJSONObject("login").getString("data");
                            //sharedPreference.saveToken(token);

                            Log.e("Success Query", "onResponse: "+bloodQueryTest);
                            Log.e("Success Response", "onResponse: "+res );

                        }else{


                            PostRequestActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(PostRequestActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
                                }
                            });

                            Log.e("Failed Query", "onResponse: "+bloodQueryTest);
                            Log.e("Failed Response", "onResponse: "+res );

                            Log.e("response Failed", "onResponse: "+json.getJSONObject("data").
                                    getJSONObject("registerUser").getJSONArray("errorList")
                                    .getJSONObject(3).getString("description") );


                            Toast.makeText(PostRequestActivity.this, ""+json.getJSONObject("data").
                                    getJSONObject("registerUser").getJSONArray("errorList")
                                    .getJSONObject(3).getString("description"), Toast.LENGTH_SHORT).show();


                        }

                    } catch (JSONException e) {
                        Log.e("Error", "onResponse: "+res);
                        e.printStackTrace();
                        Log.e("Exception Query", "onResponse: "+bloodQueryTest);
                        String tokens = sharedPreference.getToken();

                    }

                }else{
                    Log.e("Failed Response Query", "onResponse: "+bloodQueryTest);
                    Log.e("TAG", "onResponse: Not Success");

                }



            }
        });


    }

    public void selectSchedule(View view) {

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, listner, year, month, day);
        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());// disable to take previous dates
        datePickerDialog.show();
    }


    private DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            final  Calendar calendar1 = Calendar.getInstance();
            calendar1.set(dayOfMonth,month,year);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            String selectedDate = simpleDateFormat.format(calendar1.getTime());


            String date = simpleDateFormat.format(new Date());
            //birthDateBtn.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            //birthDateBtn.setText(year+"/"+(month+1)+"/"+dayOfMonth);
            scheduleTV.setText(date);


        }
    };

}