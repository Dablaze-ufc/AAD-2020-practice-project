package com.blazingtech.aad2020.ui.skilliq

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.blazingtech.aad2020.model.TopSkill
import com.blazingtech.aad2020.repository.Repository
import kotlinx.coroutines.Dispatchers

class SkillIQViewModel: ViewModel() {

    private val repository = Repository()

    var getSkillIq: LiveData<TopSkill>
    init {
         getSkillIq = liveData(Dispatchers.IO) {
            val retrievedLearners = repository.getTopSkillIq()
            emit(retrievedLearners)

        }

}


}