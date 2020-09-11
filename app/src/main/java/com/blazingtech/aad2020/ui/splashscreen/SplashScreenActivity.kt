package com.blazingtech.aad2020.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.blazingtech.aad2020.MainActivity
import com.blazingtech.aad2020.databinding.ActivitySplashScreenBinding


class SplashScreenActivity : AppCompatActivity() {


    private val viewModel: SplashScreenViewModel by viewModels()
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//       window.setDecorFitsSystemWindows(false)
        viewModel.navigateToNext.observe(this,{
            if (it){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        })

    }
}