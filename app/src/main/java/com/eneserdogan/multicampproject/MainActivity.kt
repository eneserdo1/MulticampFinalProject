package com.eneserdogan.multicampproject

import Community
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.eneserdogan.multicampproject.adapter.CommunityAdapter
import com.eneserdogan.multicampproject.service.APIService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this)

        lifecycleScope.launch {
            val retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://5f6642a143662800168e7538.mockapi.io/")
                .build()

            val ApiServis=retrofit.create(APIService::class.java)
            val myCall=ApiServis.getCommunity()

            myCall.enqueue(object :Callback<List<Community>>{
                override fun onFailure(call: Call<List<Community>>, t: Throwable) {
                    Log.e("ERROR",t.message.toString())
                }

                override fun onResponse(call: Call<List<Community>>, response: Response<List<Community>>) {
                    val communities=response.body()!!
                    val stringbuilder=StringBuilder()
                    recyclerView.adapter=CommunityAdapter(communities,applicationContext)

                }

            })
        }







    }


}