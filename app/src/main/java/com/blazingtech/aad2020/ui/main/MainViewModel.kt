package com.blazingtech.aad2020.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.blazingtech.aad2020.repository.Repository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository = Repository()


    init {
        getTopLearners()
    }

    fun getTopLearners() = liveData(Dispatchers.IO) {
        val retrievedLearners = repository.getTopLearnersFromAPI()
        emit(retrievedLearners)
    }

    fun getTopSkillIq() = liveData(Dispatchers.IO) {
        val retrievedSkillIq = repository.getTopSkillIq()
        emit(retrievedSkillIq)
    }
}