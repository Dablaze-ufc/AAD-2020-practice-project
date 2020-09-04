package com.blazingtech.aad2020.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blazingtech.aad2020.R

class ViewPagerAdapter :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder.from(parent)
    }

    override fun getItemCount() = 2

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

    }

    class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        companion object {
            fun from(parent: ViewGroup): ViewPagerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = layoutInflater.inflate(R.layout.item_skill_iq, parent, false)
                return ViewPagerViewHolder(binding)

            }
        }
    }
}