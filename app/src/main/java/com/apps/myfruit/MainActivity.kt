package com.apps.myfruit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.apps.myfruit.data.request.FruitRequest
import com.apps.myfruit.data.response.FruitItemResponse
import com.apps.myfruit.data.response.GeneralResponse
import com.apps.myfruit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val client = ApiClient.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /*
        * this is an example of how to use the API in UI,
        * you can use this in your activity or fragment
        */
        getAllFruits()
        createFruit(FruitRequest("Pepaya"))
        updateFruit("674e9da20e34421c98191ef4", FruitRequest("Pepaya Updated"))
        deleteFruit("674e9da20e34421c98191ef4")
    }


    private fun createFruit(request: FruitRequest){
        client.createFruit(request).enqueue(object : Callback<GeneralResponse> {
            override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                println("ResponseCreate: ${response.body()?.message}")
            }
            override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }

    private fun updateFruit(id: String, request: FruitRequest){
        client.updateFruit(id, request).enqueue(object : Callback<GeneralResponse> {
            override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                println("ResponseUpdate: ${response.body()?.message}")
            }
            override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }

    private fun deleteFruit(id: String){
        client.deleteFruit(id).enqueue(object : Callback<GeneralResponse> {
            override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>) {
                println("Response Delete: ${response.body()?.message}")
            }
            override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }

    private fun getAllFruits() {
        client.getAllfruits().enqueue(object : Callback<List<FruitItemResponse>> {
            override fun onResponse(
                call: Call<List<FruitItemResponse>>,
                response: Response<List<FruitItemResponse>>
            ) {
                val fruitList = response.body()
                if (fruitList != null) {
                    for (fruit in fruitList) {
                        println("Fruit: ${fruit.name}")
                    }
                }
                //todo: handle your success response data
            }

            override fun onFailure(call: Call<List<FruitItemResponse>>, t: Throwable) {
                println("Error: ${t.message}")
                //todo: handle your error
            }
        })
    }
}