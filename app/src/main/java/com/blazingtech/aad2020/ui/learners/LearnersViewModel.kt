package com.blazingtech.aad2020.ui.learners

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.blazingtech.aad2020.repository.Repository
import kotlinx.coroutines.Dispatchers

class LearnersViewModel : ViewModel() {
    private val repository = Repository()

init {
    getTopLearners()
}
    fun getTopLearners() = liveData(Dispatchers.IO) {
        val retrievedLearners = repository.getTopLearnersFromAPI()
        emit(retrievedLearners)
    }


}