package com.example.espressorobotpattern.networking

import com.example.espressorobotpattern.login.LoginRequestModel
import com.example.espressorobotpattern.login.LoginResponseModel
import com.example.espressorobotpattern.magixResponse.MagixResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ConnectionEndPoint {

    @POST("user/login")
    suspend fun login(@Body loginRequestModel: LoginRequestModel) : Call<MagixResponse<LoginResponseModel>>


}