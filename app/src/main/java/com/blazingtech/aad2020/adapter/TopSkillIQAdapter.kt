package com.blazingtech.aad2020.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blazingtech.aad2020.R
import com.blazingtech.aad2020.databinding.ItemSkillIqBinding
import com.blazingtech.aad2020.model.TopSkillItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

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
            ItemSkillIqBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: SkillIQViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class SkillIQViewHolder(private var binding: ItemSkillIqBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(learner: TopSkillItem){

            binding.nameTopSkill.text = learner.name
            binding.textCountry.text = learner.country
            binding.textScore.text = "${learner.score} Skill iq score"

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_broken_image)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(learner.badgeUrl)
                .into(binding.imageViewSkillIq)

        }
    }
}