package com.apps.myfruit.data.request

import com.google.gson.annotations.SerializedName

data class FruitRequest(
    @SerializedName("name")
    val name: String = ""
)