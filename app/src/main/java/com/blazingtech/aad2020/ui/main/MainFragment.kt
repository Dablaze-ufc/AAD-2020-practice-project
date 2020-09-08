package com.blazingtech.aad2020.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.blazingtech.aad2020.adapter.ViewPagerAdapter
import com.blazingtech.aad2020.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         binding.viewPager.adapter = ViewPagerAdapter()

        viewModel.getTopLearners().observe(viewLifecycleOwner,{
            binding.viewPager.adapter = null
            val adapter = ViewPagerAdapter(learners = it)
            binding.viewPager.adapter = adapter
        })

        viewModel.getTopSkillIq().observe(viewLifecycleOwner,{
            binding.viewPager.adapter = null
            val adapter = ViewPagerAdapter(skill  = it)
            binding.viewPager.adapter = adapter
        })

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            when(position){
                0 ->  {
                    tab.text = "Learning Leaders"}
               else -> {

                   tab.text = "Skill IQ Leaders"}
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> viewModel.getTopLearners()
                    1 -> viewModel.getTopSkillIq()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }

}