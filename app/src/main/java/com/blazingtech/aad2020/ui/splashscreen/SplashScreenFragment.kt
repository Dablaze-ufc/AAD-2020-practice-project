package com.blazingtech.aad2020.ui.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.blazingtech.aad2020.R
import com.blazingtech.aad2020.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {


    private lateinit var viewModel: SplashScreenViewModel
    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentSplashScreenBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateToNext.observe(viewLifecycleOwner,{
            if (it){
                findNavController().navigate(R.id.action_splashScreenFragment_to_mainFragment)
            }
        })
    }

}