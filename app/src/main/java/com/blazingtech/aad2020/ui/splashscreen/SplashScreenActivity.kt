package com.blazingtech.aad2020.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.blazingtech.aad2020.MainActivity
import com.blazingtech.aad2020.databinding.ActivityMainBinding


class SplashScreenActivity : AppCompatActivity() {


    private lateinit var viewModel: SplashScreenViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = ViewModelProvider(this)[SplashScreenViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.navigateToNext.observe(this,{
            if (it){
                startActivity(Intent(this,MainActivity::class.java))
            }
        })

    }
}