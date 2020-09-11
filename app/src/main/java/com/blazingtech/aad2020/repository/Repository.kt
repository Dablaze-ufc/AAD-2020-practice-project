package com.blazingtech.aad2020.repository


import com.blazingtech.aad2020.data.remote.RetrofitService
import com.blazingtech.aad2020.data.remote.webservice

class Repository {
    private var client: RetrofitService = webservice

    suspend fun getTopLearnersFromAPI() = client.getTopLearners()

    suspend fun getTopSkillIq() = client.getSkill()

    suspend fun postSubmission(firstName: String,
                               lastName:String,
                               email:String,
                               link:String) = client.submitEntry(firstName, lastName, email, link)
}