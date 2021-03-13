package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class SignUpActivity8 extends AppCompatActivity {


    public  static final String baseUrl ="http://192.168.1.230:8085/graphql/";
    private SharedPreference sharedPreference;
    private String imageLink;
    private Button signUpNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up8);

        signUpNextBtn = findViewById(R.id.signUpNextBtn);


        sharedPreference = new SharedPreference(this);

        Log.e("sss", "onCreate: "+sharedPreference.getUserDetails().get(sharedPreference.KEY_DATEBIRTH));

        signUpNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreference.saveImage("image");


                String email =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_EMAIL)+"\"";
                String pass =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_PASSWORD)+"\"";
                String mobile =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_MOBILE)+"\"";
                String altmobile =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_ALTER_MOBILE)+"\"";
                String blood =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_BLOOD)+"\"";

                String gender =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_GENDER)+"\"";
                String district =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_DISTRICT)+"\"";
                String union =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_UNION)+"\"";
                String postoffice =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_POSTOFFICE)+"\"";
                String police =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_USER_POLICE)+"\"";
                String dateofbirth =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_DATEBIRTH)+"\"";
                String donationDate =  "\""+sharedPreference.getUserDetails().get(sharedPreference.KEY_DONATIONBLOOD)+"\"";


                String queryRegistration = "mutation {\n" +
                        "  registerUser(input: {\n" +
                        "    name: \"abir\"\n" +
                        "    email: \"abir3@gmail.com\"\n" +
                        "    password: \"12345678\"\n" +
                        "    mobileNumber: \"01521231706\"\n" +
                        "    alternateMobileNumber: \"01879205152\"\n" +
                        "    socialLink: \"fb\"\n" +
                        "    bloodGroup: \"O_positive\"\n" +
                        "    weight: 108\n" +
                        "    gender: \"male\"\n" +
                        "    religion: \"islam\"\n" +
                        "    district: \"comilla\"\n" +
                        "    unionName: \"baksimul\"\n" +
                        "    postOffice: \"kalikapur\"\n" +
                        "    policeStation: \"burichong\"\n" +
                        "    dateOfBirth: \"1997-04-05\"\n" +
                        "    lastBloodDonationDate: \"2020-01-03\"\n" +
                        "    imageLink: \"sfsdf\"\n" +
                        "    longitude: 44.33\n" +
                        "    latitude: 33.33\n" +
                        "  }){\n" +
                        "    status\n" +
                        "    code\n" +
                        "    user{\n" +
                        "      id\n" +
                        "    }\n" +
                        "    errorList{\n" +
                        "      code\n" +
                        "      field\n" +
                        "      message\n" +
                        "      description\n" +
                        "    }\n" +
                        "  }\n" +
                        "}\n";




                String queryRegistration2 = "mutation {\n" +
                        "  registerUser(input: {\n" +
                        "    name:\"Kader\"\n" +
                        "    email: "+email+"\n" +
                        "    password: "+pass+"\n" +
                        "    mobileNumber: "+mobile+"\n" +
                        "    alternateMobileNumber: "+altmobile+"\n" +
                        "    socialLink: \"fb\"\n" +
                        "    bloodGroup: "+blood+"\n" +
                        "    weight: "+sharedPreference.getWeight()+"\n"+
                        "    gender: "+gender+"\n" +
                        "    religion: \"islam\"\n" +
                        "    district: "+district+"\n" +
                        "    unionName: "+union+"\n" +
                        "    postOffice: "+postoffice+"\n" +
                        "    policeStation: "+police+"\n" +
                        "    dateOfBirth: "+dateofbirth+"\n" +
                        "    lastBloodDonationDate: "+donationDate+"\n" +
                        "    imageLink: \"sfsdf\"\n" +
                        "    longitude: 44.33\n" +
                        "    latitude: 33.33\n" +
                        "  }){\n" +
                        "    status\n" +
                        "    code\n" +
                        "    user{\n" +
                        "      id\n" +
                        "    }\n" +
                        "    errorList{\n" +
                        "      code\n" +
                        "      field\n" +
                        "      message\n" +
                        "      description\n" +
                        "    }\n" +
                        "  }\n" +
                        "}\n";



                OkHttpClient okHttpClient = new OkHttpClient();

                final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");


                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("query",queryRegistration2);
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
                        Toast.makeText(SignUpActivity8.this, "OkHTTP:"+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("TAG", "onFailure: "+e.getLocalizedMessage() );


                        Log.e("OkHTTP", "onResponse: "+baseUrl );
                    }

                    @Override
                    public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {

                        if(response.isSuccessful()){


                            try {
                                String res = response.body().string();
                                JSONObject json = new JSONObject(res);

                                String code = json.getJSONObject("data").getJSONObject("registerUser").getString("code");

                                int codeRequest = Integer.parseInt(code);


                                Log.e("Initial Query", "onResponse: "+queryRegistration2);
                                if(codeRequest == 200){



                                    //String token = json.getJSONObject("login").getString("data");
                                    //sharedPreference.saveToken(token);
                                    startActivity(new Intent(SignUpActivity8.this,HomeActivity.class));
                                    Log.e("Success Query", "onResponse: "+queryRegistration2);
                                    Log.e("Success Response", "onResponse: "+res );
                                    String userID = json.getJSONObject("data").getJSONObject("registerUser").getJSONObject("user").getString("id");


                                    sharedPreference.saveUserID(userID);


                                }else{


                                    Log.e("Failed Query", "onResponse: "+queryRegistration2);
                                    Log.e("Failed Response", "onResponse: "+res );

                                    Log.e("response Failed", "onResponse: "+json.getJSONObject("data").
                                            getJSONObject("registerUser").getJSONArray("errorList")
                                            .getJSONObject(3).getString("description") );


                                    Toast.makeText(SignUpActivity8.this, ""+json.getJSONObject("data").
                                            getJSONObject("registerUser").getJSONArray("errorList")
                                            .getJSONObject(3).getString("description"), Toast.LENGTH_SHORT).show();


                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e("Exception Query", "onResponse: "+e);
                            }

                        }else{
                            Log.e("Failed Response Query", "onResponse: "+queryRegistration2);
                            Log.e("TAG", "onResponse: Not Success");

                        }



                    }
                });
            }
        });
    }



    public void uploadImage(View view) {

    }
}