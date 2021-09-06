package com.example.espressorobotpattern.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun makeRetrofitService() : ConnectionEndPoint {
        return Retrofit.Builder()
            .baseUrl("https://magixmusiemapi-qc.azurewebsites.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConnectionEndPoint::class.java)
    }
}