package com.blazingtech.aad2020.ui.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class SplashScreenViewModel : ViewModel() {
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToNext = MutableLiveData(false)

    val navigateToNext :LiveData<Boolean> = _navigateToNext

   init {

       uiScope.launch { delay(3000)
           withContext(Dispatchers.Main){
           _navigateToNext.value = true
       } }

   }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}