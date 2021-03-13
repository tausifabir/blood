package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.blooddonation.Adapter.MyRequestAdapter;
import com.example.blooddonation.Adapter.UrgentRequestAdapter;
import com.example.blooddonation.Constant.Constant;
import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MyRequestActivity extends AppCompatActivity {

    private RecyclerView requestRecyclerview;

    private MyRequestAdapter myRequestAdapter;
    private SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        getApi();

        requestRecyclerview = findViewById(R.id.requestRecyclerview);

        ArrayList<String> fragmentTittle = new ArrayList<>();
        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");







    }


    private void getApi() {
        sharedPreference = new SharedPreference(this);
        String email =  "\""+sharedPreference.getUserEmailLogin()+"\"";

        String myRequestQuery = "query {\n" +
                "  getUserAllBloodRequestInformation(identity: \"abir1@gmail.com\"){\n" +
                "    status\n" +
                "    code\n" +
                "    bloodRequestInformationSet{\n" +
                "      id\n" +
                "      bloodRequester{\n" +
                "        id\n" +
                "        name\n" +
                "      }\n" +
                "      bloodRequest{\n" +
                "        timeFrame\n" +
                "        location{\n" +
                "          district\n" +
                "        }\n" +
                "        relationShipWithPatient\n" +
                "        requestedBloodGroup\n" +
                "      }\n" +
                "    }\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message\n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";




        String myRequestQuery1 = "query {\n" +
                "  getUserAllBloodRequestInformation(identity: "+email+"){\n" +
                "    status\n" +
                "    code\n" +
                "    bloodRequestInformationSet{\n" +
                "      id\n" +
                "      bloodRequester{\n" +
                "        id\n" +
                "        name\n" +
                "      }\n" +
                "      bloodRequest{\n" +
                "        timeFrame\n" +
                "        location{\n" +
                "          district\n" +
                "        }\n" +
                "        relationShipWithPatient\n" +
                "        requestedBloodGroup\n" +
                "      }\n" +
                "    }\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message\n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";

        OkHttpClient okHttpClient = new OkHttpClient();


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("query",myRequestQuery1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(null,jsonObject.toString());
        Request request = new Request.Builder()
                .url(Constant.baseUrl)
                //.post(formBody)
                .post(requestBody)
                .build();


        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {

                Log.e("TAG", "onFailure: "+e.getLocalizedMessage() );


            }

            @Override
            public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {

                String res = response.body().string();
                if(response.isSuccessful()){

                    try {
                        JSONObject json = new JSONObject(res);
                        String code = json.getJSONObject("data").getJSONObject("getUserAllBloodRequestInformation").getString("code");
                        int codeRequest = Integer.parseInt(code);

                        if(codeRequest == 200){

                            JSONArray jsonArray = json.getJSONObject("data").getJSONObject("getUserAllBloodRequestInformation").getJSONArray("bloodRequestInformationSet");
                            Log.e("ResponseTAG", "onResponse: "+res );
                            MyRequestActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {


                                    Log.e("TAG", "run: "+jsonArray );


                                    myRequestAdapter = new MyRequestAdapter(MyRequestActivity.this,jsonArray);
                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyRequestActivity.this);
                                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                                    requestRecyclerview.setLayoutManager(linearLayoutManager);
                                    requestRecyclerview.setAdapter(myRequestAdapter);
                                    myRequestAdapter.notifyDataSetChanged();
                                }
                            });



                        }else{

                            MyRequestActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MyRequestActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
                                    Log.e("Failed Query", "run: "+myRequestQuery1 );
                                }

                            });

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("Exception", "onResponse: "+e.getLocalizedMessage() );
                        Log.e("Exception Response", "onResponse: "+res);
                        Log.e("Exception Query", "onResponse: "+myRequestQuery);

                    }

                }else{

                    Log.e("Response Failed", "onResponse: "+res);

                }

            }
        });

    }

}