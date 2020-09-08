package com.blazingtech.aad2020.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blazingtech.aad2020.R
import com.blazingtech.aad2020.model.Learners
import com.blazingtech.aad2020.model.TopSkill
import kotlinx.android.synthetic.main.fragment_learning_leaders.view.*

class ViewPagerAdapter(private var skill: TopSkill? = null, private var learners: Learners? = null  ) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder.from(parent)
    }

    override fun getItemCount() = 2

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        holder.bind(position, learners, skill)

    }

    class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, learners: Learners?, skill: TopSkill?) {

            itemView.recyclerView?.apply {
                when(position){
                    0 -> {
                        val adapter = TopLearnersAdapter()
                        this.adapter = adapter
                        learners?.let {
                            adapter.submitList(it)
                        }

                    }

                    else -> {
                        val adapter = TopSkillIQAdapter()
                        this.adapter = adapter
                        skill?.let {
                            adapter.submitList(it)
                        }
                    }

                }
            }

        }

        companion object {
            fun from(parent: ViewGroup): ViewPagerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = layoutInflater.inflate(R.layout.fragment_learning_leaders, parent, false)
                return ViewPagerViewHolder(binding)

            }
        }
    }
}