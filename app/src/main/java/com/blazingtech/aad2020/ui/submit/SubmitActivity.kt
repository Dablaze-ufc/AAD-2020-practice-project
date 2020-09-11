package com.blazingtech.aad2020.ui.submit

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.blazingtech.aad2020.databinding.ActivitySubmitBinding

class SubmitActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: SubmitViewModel by viewModels()
    private lateinit var binding: ActivitySubmitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (isValid()){
            viewModel.submit(binding.submitBody.firstName.text.toString(),binding.submitBody.lastName.text.toString()
                ,binding.submitBody.emailAddress.text.toString(),binding.submitBody.githubLink.text.toString())
                .observe(this,{ response ->

                })
        }




    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    private fun isValid() = binding.submitBody.emailAddress.text.isNotEmpty() &&
            binding.submitBody.firstName.text.isNotEmpty() &&
            binding.submitBody.githubLink.text.isNotEmpty() &&
            binding.submitBody.lastName.text.isNotEmpty()


}