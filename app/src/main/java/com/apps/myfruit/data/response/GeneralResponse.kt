package com.apps.myfruit.data.response


import com.google.gson.annotations.SerializedName

data class GeneralResponse(
    @SerializedName("message")
    val message: String = ""
)