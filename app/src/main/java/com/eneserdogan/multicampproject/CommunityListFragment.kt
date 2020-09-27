package com.eneserdogan.multicampproject

import Community
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.eneserdogan.multicampproject.adapter.CommunityAdapter
import com.eneserdogan.multicampproject.service.APIService
import kotlinx.android.synthetic.main.fragment_community_list.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommunityListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager= LinearLayoutManager(requireContext().applicationContext)


        lifecycleScope.launch {
            val retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://5f6642a143662800168e7538.mockapi.io/")
                .build()

            val ApiServis=retrofit.create(APIService::class.java)
            val myCall=ApiServis.getCommunity()

            myCall.enqueue(object : Callback<List<Community>> {
                override fun onFailure(call: Call<List<Community>>, t: Throwable) {
                    Log.e("ERROR",t.message.toString())
                }

                override fun onResponse(call: Call<List<Community>>, response: Response<List<Community>>) {
                    val communities=response.body()!!
                    val stringbuilder=StringBuilder()
                    recyclerView.adapter= CommunityAdapter(communities,requireContext().applicationContext)

                }

            })
        }
    }

}