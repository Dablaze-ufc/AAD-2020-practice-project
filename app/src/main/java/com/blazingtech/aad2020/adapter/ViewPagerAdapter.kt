package com.blazingtech.aad2020.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.blazingtech.aad2020.ui.learners.LearnersFragment
import com.blazingtech.aad2020.ui.skilliq.SkillIqFragment
import java.io.InvalidObjectException

class ViewPagerAdapter(
    fragmentManager: FragmentManager, lifeCycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifeCycle) {


    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LearnersFragment()
            1 -> SkillIqFragment()
            else -> throw InvalidObjectException("Object is invalid or does not exist within this scope")
        }
    }
}