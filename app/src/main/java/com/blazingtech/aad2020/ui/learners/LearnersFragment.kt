package com.blazingtech.aad2020.ui.learners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.blazingtech.aad2020.adapter.TopLearnersAdapter

import com.blazingtech.aad2020.databinding.FragmentLearnersBinding

class LearnersFragment : Fragment() {

    private val viewModel: LearnersViewModel by viewModels()
    private lateinit var binding: FragmentLearnersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearnersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTopLearners().observe(viewLifecycleOwner,{
            binding.recyclerLearners.apply {
                val adapter = TopLearnersAdapter()
                this.adapter = adapter
                binding.progressBarLearners.visibility = View.GONE
                adapter.submitList(it)
            }
        })



    }

}