package com.blazingtech.aad2020.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blazingtech.aad2020.R
import com.blazingtech.aad2020.model.TopSkillItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_skill_iq.view.*

class TopSkillIQAdapter: ListAdapter<TopSkillItem, TopSkillIQAdapter.SkillIQViewHolder>(DiffCallback) {
    companion object DiffCallback: DiffUtil.ItemCallback<TopSkillItem>() {
        override fun areItemsTheSame(oldItem: TopSkillItem, newItem: TopSkillItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TopSkillItem, newItem: TopSkillItem): Boolean {
            return oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillIQViewHolder {
        return SkillIQViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_skill_iq, parent,false)
        )
    }

    override fun onBindViewHolder(holder: SkillIQViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class SkillIQViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(learner: TopSkillItem){

            itemView.nameTopSkill.text = learner.name
            itemView.textCountry.text = learner.country
            itemView.textScore.text = "${learner.score} Skill iq score"

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_broken_image)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(learner.badgeUrl)
                .into(itemView.imageViewSkillIq)

        }
    }
}