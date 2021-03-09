package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.blooddonation.Adapter.DonationAdapter;
import com.example.blooddonation.Adapter.UrgentRequestAdapter;
import com.example.blooddonation.Constant.Constant;
import com.example.blooddonation.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class UrgentRequestsActivity extends AppCompatActivity {

    private UrgentRequestAdapter urgentRequestAdapter;

    private RecyclerView urgentRecyclerview;


    private Spinner sortedSpinner;

    public  static final String baseUrl ="http://192.168.1.230:8085/graphql/";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_requests);


        urgentRecyclerview = findViewById(R.id.urgentRecyclerview);
        sortedSpinner = findViewById(R.id.sortedSpinner);




        getApi();

        ArrayList<String> fragmentTittle = new ArrayList<>();
        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");




        ArrayList<String> sortTittle = new ArrayList<>();
        fragmentTittle.add("Time");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        //sortSpinner = findViewById(R.id.sortSpinner);






        urgentRequestAdapter = new UrgentRequestAdapter(UrgentRequestsActivity.this,fragmentTittle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UrgentRequestsActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        urgentRecyclerview.setLayoutManager(linearLayoutManager);
        urgentRecyclerview.setAdapter(urgentRequestAdapter);
        urgentRequestAdapter.notifyDataSetChanged();


        ArrayAdapter<String> sortedAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,sortTittle);

        sortedSpinner.setAdapter(sortedAdapter);




    }

    private void getApi() {


        String getAllRequestQuery = "\n" +
                "query {\n" +
                "  getAllBloodRequestInformation{\n" +
                "    status\n" +
                "    code\n" +
                "    bloodRequestInformationSet{\n" +
                "      id\n" +
                "      bloodRequester{\n" +
                "        id\n" +
                "        name\n" +
                "      }\n" +
                "    }\n" +
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
            jsonObject.put("query",getAllRequestQuery);
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

                        String code = json.getJSONObject("data").getJSONObject("getAllBloodRequestInformation").getString("code");

                        int codeRequest = Integer.parseInt(code);



                        if(codeRequest == 200){



                            Log.e("ResponseTAG", "onResponse: "+res );
                            UrgentRequestsActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(UrgentRequestsActivity.this, "Request has posted successfully", Toast.LENGTH_SHORT).show();
                                }
                            });

                            //String token = json.getJSONObject("login").getString("data");
                            //sharedPreference.saveToken(token);


                            JSONArray jsonArray = json.getJSONObject("data").getJSONObject("getAllBloodRequestInformation").getJSONArray("bloodRequestInformationSet");
                            Log.e("Success Response", "onResponse: "+res );




                            for(int i = 0;i<= jsonArray.length();i++ ){

                                JSONObject animal = jsonArray.getJSONObject(i);

                                int id = animal.getInt("id");
                                String name = animal.getString("name");

                                Log.e("Id", "onResponse: "+id );
                                Log.e("Name", "onResponse: "+name );


                            }

                        }else{


                            UrgentRequestsActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(UrgentRequestsActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
                                }
                            });

                            Log.e("Failed Query", "onResponse: "+getAllRequestQuery);
                            Log.e("Failed Response", "onResponse: "+res );

                            Log.e("response Failed", "onResponse: "+json.getJSONObject("data").
                                    getJSONObject("registerUser").getJSONArray("errorList")
                                    .getJSONObject(3).getString("description") );


                            Toast.makeText(UrgentRequestsActivity.this, ""+json.getJSONObject("data").
                                    getJSONObject("registerUser").getJSONArray("errorList")
                                    .getJSONObject(3).getString("description"), Toast.LENGTH_SHORT).show();


                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("Exception Query", "onResponse: "+getAllRequestQuery);
                        Log.e("TAG", "onResponse: "+baseUrl );
                        Log.e("Exception", "onResponse: "+e.getLocalizedMessage() );
                        Log.e("ResponseTAG", "onResponse: "+res );
                    }

                }else{
                    Log.e("Failed Response Query", "onResponse: "+getAllRequestQuery);
                    Log.e("TAG", "onResponse: Not Success");

                }



            }
        });

    }
}