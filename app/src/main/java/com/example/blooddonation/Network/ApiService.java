package com.example.blooddonation.Network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
//
//    @Headers("Content-Type: application/json")
//    @POST("/")
//    Call<String> getUser(@Body String body);

    @Headers("Content-Type: application/json")
    @POST("/")
    Call<String> login(@Body String body);


}
