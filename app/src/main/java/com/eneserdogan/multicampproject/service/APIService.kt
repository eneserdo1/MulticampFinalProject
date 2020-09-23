package com.eneserdogan.multicampproject.service

import Community
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("multicamp/communities")
    fun getCommunity():Call<List<Community>>
}