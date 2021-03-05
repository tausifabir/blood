package com.example.blooddonation.Kotlin

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object GraphQLInstance {

    private const val BASE_URL: String = "http://192.155.1.55:2000/"

    val graphQLService: GraphQLService by lazy {
        Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build().create(GraphQLService::class.java)
    }
}