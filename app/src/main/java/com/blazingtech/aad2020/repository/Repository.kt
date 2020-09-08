package com.blazingtech.aad2020.repository


import com.blazingtech.aad2020.data.remote.RetrofitService
import com.blazingtech.aad2020.data.remote.webservice

class Repository {
    var client: RetrofitService = webservice

    suspend fun getTopLearnersFromAPI() = client.getTopLearners()

    suspend fun getTopSkillIq() = client.getSkill()
}