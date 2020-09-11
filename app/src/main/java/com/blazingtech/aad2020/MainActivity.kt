package com.blazingtech.aad2020

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blazingtech.aad2020.adapter.ViewPagerAdapter
import com.blazingtech.aad2020.databinding.ActivityMainBinding
import com.blazingtech.aad2020.ui.submit.SubmitActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbar)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter



        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            when(position){
                0 ->  {
                    tab.text = "Learning Leaders"}
                else -> {

                    tab.text = "Skill IQ Leaders"}
            }
        }.attach()

        binding.submitButton.submitBtn.setOnClickListener{
            startActivity(Intent(this, SubmitActivity::class.java))
        }

    }
}