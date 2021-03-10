package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.blooddonation.Network.ApiService;
import com.example.blooddonation.Network.RetrofitClient;
import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;


import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


public class LoginActivity extends AppCompatActivity {


    //public  static final String baseUrl ="https://newsapi.org/";


    public  static final String baseUrl ="http://192.168.1.230:8085/graphql/";
    //public  static final String baseUrl ="https://graphql-weather-api.herokuapp.com/";
    //public  static final String baseUrl ="https://reqres.in/api/register/";


    SharedPreference sharedPreference;

    private Button loginBtn;
    private TextView signUp,forgotTV;
    private EditText userEmailET,userPassET;

    private  String  userPass, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.signUpNextBtn);
        signUp = findViewById(R.id.signupBtn);
        forgotTV = findViewById(R.id.forgotTV);

        userEmailET = findViewById(R.id.userEmailET);
        userPassET = findViewById(R.id.userPassET);


        sharedPreference = new SharedPreference(this);







        String query5 ="query {tausif}";


        String query2 = "mutation {\n" +
                "  registerUser(input: {\n" +
                "    name: \"sagar\"\n" +
                "    email: \"sagar1@gmail.com\"\n" +
                "    password: \"123456789\"\n" +
                "    mobileNumber: \"01521231706\"\n" +
                "    alternateMobileNumber: \"01879205152\"\n" +
                "    socialLink: \"saerg\"\n" +
                "    bloodGroup: \"a_positive\"\n" +
                "    weight: 88\n" +
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
                "}";
        String query3 = "query {getCityByName(name: \"Barcelona\"){id,name,{id,name,country,coord {lon,lat}}}}";
        String query4 = "{\n" +
                "    \"name\": \"ssss\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        ApiService apiService = RetrofitClient
                .getClient(baseUrl)
                .create(ApiService.class);


     /*   try{
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(baseUrl);


            StringEntity postingString = new StringEntity(query);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            Log.e("Http", "onCreate: "+response.toString() );

        }catch (Exception e){

            e.printStackTrace();
        }*/





        OkHttpClient okHttpClient = new OkHttpClient();








        RequestBody formBody = new FormBody.Builder()
                .add("getCityByName", "Barcelona")
                //.add("getCityByName", "Barcelona")
                //.add("getCityByName", "Barcelona")
                //.add("getCityByName", "Barcelona")
                .build();






        String query = "mutation {\n" +
                "  login(email: \"sagar@gmail.com\", password: \"hwllosdfsf\", rememberMe: true){\n" +
                "    status\n" +
                "    code\n" +
                "    data\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message\n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";


        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("query",query);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(null,jsonObject.toString());

        Request request = new Request.Builder()
                .url(baseUrl)
                //.post(formBody)
                .post(requestBody)
                .build();
/*
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {
                Toast.makeText(LoginActivity.this, "OkHTTP:"+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", "onFailure: "+e.getLocalizedMessage() );


                Log.e("OkHTTP", "onResponse: "+baseUrl );
            }

            @Override
            public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {

                if(response.isSuccessful()){


                    Log.e("OkHTTPSuccess", "onResponse: "+response.code() );
                    String res = response.body().string();
                    Log.e("CatchResponse: ", "onResponse: "+res );
                    Log.e("OkHTTPSuccess", "onResponse: "+baseUrl );


                }



            }
        });*/





      /*  apiService.login(query2)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {


                        if (response.isSuccessful()){

                            Toast.makeText(LoginActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                            Log.e("BAse", "onResponse: "+baseUrl );
                        }else{
                            Log.e("onFailureCode: ", "onResponse: "+response.code() );
                            Log.e("BAse", "onResponse: "+baseUrl );


                        }



                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, ""+t, Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, ""+baseUrl, Toast.LENGTH_SHORT).show();

                        Log.e("onFailure: ", "onFailure: "+t );
                        Log.e("BAse", "onResponse: "+baseUrl );


                    }
                });*/









        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity1.class));
            }
        });





    }

    public void clickLogin(View view) {

        userEmail = userEmailET.getText().toString();
        userPass = userPassET.getText().toString();


        String email =  "\""+userEmail+"\"";
        String pass =  "\""+userPass+"\"";



        OkHttpClient okHttpClient = new OkHttpClient();


        String queryTest = "mutation {\n" +
                "  login(email:"+email+", password: "+pass+", rememberMe: true){\n" +
                "    status\n" +
                "    code\n" +
                "    data\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message\n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";


        String queryTest12 = "mutation {\n" +
                "  login(email:\"+userEmail+\", password: \"+userPass+\", rememberMe: true){\n" +
                "    status\n" +
                "    code\n" +
                "    data\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message\n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";

        String queryTest1 = "mutation {\n" +
                "  login(email:\"abir@gmail.com\", password: \"12345678\", rememberMe: true){\n" +
                "    status\n" +
                "    code\n" +
                "    data\n" +
                "    errorList{\n" +
                "      code\n" +
                "      field\n" +
                "      message\n" +
                "      description\n" +
                "    }\n" +
                "  }\n" +
                "}";



        String query3 = "query {getCityByName(name: \"Barcelona\"){id,name,{id,name,country,coord {lon,lat}}}}";
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("query",queryTest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(null,jsonObject.toString());

        Request request = new Request.Builder()
                .url(baseUrl)
                //.post(formBody)
                .post(requestBody)
                .build();


        if(userEmail.isEmpty() || userPass.isEmpty()){

            userEmailET.setError("Field must not be empty");
            userPassET.setError("Field must not be empty");

        }else{


            okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {


                    LoginActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, ""+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                    Log.e("TAG", "onFailure: "+e.getLocalizedMessage() );


                    Log.e("OkHTTP", "onResponse: "+baseUrl );
                }

                @Override
                public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {



                    if(response.isSuccessful()){

                        try {
                            String res = response.body().string();
                            JSONObject json = new JSONObject(res);

                            Log.e("CatchResponse: ", "onResponse: "+res );

                            Log.e("OkHTTPSuccess", "onResponse: "+baseUrl );

                            String code = json.getJSONObject("data").getJSONObject("login").getString("code");

                            int codeRequest = Integer.parseInt(code);


                            if(codeRequest == 200){



                                sharedPreference.saveUserEmailLogin(userEmail);

                                String token = json.getJSONObject("data").getJSONObject("login").getString("data");
                                sharedPreference.saveToken(token);
                                Log.e("TOKEN", "onResponse: "+token );
                                startActivity(new Intent(LoginActivity.this,HomeActivity.class));



                            }else{

                                LoginActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Toast.makeText(LoginActivity.this, ""+json.getJSONObject("data").getJSONObject("login").getJSONArray("errorList").getJSONObject(0).getString("description"), Toast.LENGTH_SHORT).show();

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                });

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("TAG", "onResponse: "+e );
                        }

                    }
                }
            });


        }


    }

}
