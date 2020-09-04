package com.blazingtech.aad2020.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.blazingtech.aad2020.repository.Repository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository = Repository()


    val topLearners = liveData(Dispatchers.IO){
        val retrievedLearners = repository.getTopLearnersFromAPI()
        emit(retrievedLearners)
    }

    val topSkillIq = liveData(Dispatchers.IO){
        val retrievedSkillIq = repository.getTopSkillIq()
        emit(retrievedSkillIq)
    }
}