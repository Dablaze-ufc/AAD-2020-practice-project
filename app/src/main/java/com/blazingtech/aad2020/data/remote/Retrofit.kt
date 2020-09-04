package com.blazingtech.aad2020.data.remote

import com.blazingtech.aad2020.model.Learners
import com.blazingtech.aad2020.model.TopSkill
import com.blazingtech.aad2020.util.Constants.BASEURL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService{
    @GET("api/hours")
    suspend fun getTopLearners(): Learners

    @GET("api/skilliq")
    suspend fun getSkill(): TopSkill
}

    val webservice: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(RetrofitService::class.java)
    }
