package com.blazingtech.aad2020.ui.submit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.blazingtech.aad2020.repository.Repository
import kotlinx.coroutines.Dispatchers

class SubmitViewModel : ViewModel() {
    private val repository = Repository()


    fun submit(firstName: String,
               lastName:String,
               email:String,
               link:String) = liveData(Dispatchers.IO){
        val response = repository.postSubmission(firstName, lastName, email, link)
        emit(response)
    }


}