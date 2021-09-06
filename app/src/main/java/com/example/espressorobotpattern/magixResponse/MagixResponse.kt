package com.example.espressorobotpattern.magixResponse

import com.google.gson.annotations.SerializedName

class MagixResponse<T> {
    @SerializedName("statusCode")
    val code: Int? = 0

    @SerializedName("message")
    val message: String? = ""

    @SerializedName("result")
    val data: T? = null

    @SerializedName("responseException")
    val responseException: ResponseException? = null
}