package com.apps.myfruit.data.response


import com.google.gson.annotations.SerializedName

data class FruitItemResponse(
    @SerializedName("_id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)