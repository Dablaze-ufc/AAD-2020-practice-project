package com.blazingtech.aad2020.data.remote

import com.blazingtech.aad2020.model.Learners
import com.blazingtech.aad2020.model.TopSkill
import com.blazingtech.aad2020.util.Constants.BASE_URL
import com.blazingtech.aad2020.util.Constants.EMAIL_ADDRESS
import com.blazingtech.aad2020.util.Constants.LAST_NAME
import com.blazingtech.aad2020.util.Constants.LINK_TO_PROJECT
import com.blazingtech.aad2020.util.Constants.NAME
import com.blazingtech.aad2020.util.Constants.POST_ID
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService{
    @GET("/api/hours")
    suspend fun getTopLearners(): Learners

    @GET("/api/skilliq")
    suspend fun getSkill(): TopSkill

    @POST(POST_ID)
    @FormUrlEncoded
    suspend fun submitEntry(
        @Field(NAME) firstName:String,
        @Field(LAST_NAME) lastName: String,
        @Field(EMAIL_ADDRESS) email: String,
        @Field(LINK_TO_PROJECT) link: String
    )
}


    val webservice: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(RetrofitService::class.java)
    }
