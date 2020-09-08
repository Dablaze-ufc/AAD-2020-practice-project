package com.blazingtech.aad2020.ui.skilliq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.blazingtech.aad2020.databinding.FragmentSkillIqBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SkillIqFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SkillIqFragment : Fragment() {
    private val viewModel: SkillIQViewModel by viewModels()
    private lateinit var binding : FragmentSkillIqBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSkillIqBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}