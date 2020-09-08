package com.blazingtech.aad2020.ui.skilliq

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.blazingtech.aad2020.repository.Repository
import kotlinx.coroutines.Dispatchers

class SkillIQViewModel: ViewModel() {

    private val repository = Repository()


    init {
        fun getSkillIq() = liveData(Dispatchers.IO) {
            val retrievedLearners = repository.getTopSkillIq()
            emit(retrievedLearners)

        }
}
}