package com.example.espressorobotpattern.magixResponse

import com.google.gson.annotations.SerializedName

data class ResponseException(
    @SerializedName("details")
    val details: Any,
    @SerializedName("exceptionMessage")
    val exceptionMessage: String,
    @SerializedName("isError")
    val isError: Boolean,
    @SerializedName("referenceDocumentLink")
    val referenceDocumentLink: Any,
    @SerializedName("referenceErrorCode")
    val referenceErrorCode: Any,
    @SerializedName("validationErrors")
    val validationErrors: Any
)