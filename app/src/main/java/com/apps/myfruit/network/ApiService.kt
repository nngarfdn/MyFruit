package com.apps.myfruit.network

import com.apps.myfruit.data.request.FruitRequest
import com.apps.myfruit.data.response.FruitItemResponse
import com.apps.myfruit.data.response.GeneralResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {

    @GET("fruits")
    fun getAllfruits(): Call<List<FruitItemResponse>>

    @POST("fruits")
    fun createFruit(@Body request: FruitRequest): Call<GeneralResponse>

    @POST("fruits/{id}")
    fun updateFruit(@Path("id") id: String, @Body request: FruitRequest): Call<GeneralResponse>

    @DELETE("fruits/{id}")
    fun deleteFruit(@Path("id") id: String): Call<GeneralResponse>
}