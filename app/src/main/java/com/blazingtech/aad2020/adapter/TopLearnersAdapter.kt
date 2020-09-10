package com.blazingtech.aad2020.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blazingtech.aad2020.R
import com.blazingtech.aad2020.model.LearnersItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_learning_leaders.view.*

class TopLearnersAdapter : ListAdapter<LearnersItem,TopLearnersAdapter.LearnersViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<LearnersItem>() {
        override fun areItemsTheSame(oldItem: LearnersItem, newItem: LearnersItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: LearnersItem, newItem: LearnersItem): Boolean {
            return oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnersViewHolder {
       return LearnersViewHolder(
          LayoutInflater.from(parent.context).inflate(R.layout.item_learning_leaders,parent,false)
       )
    }

    override fun onBindViewHolder(holder: LearnersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class LearnersViewHolder(private var binding: View): RecyclerView.ViewHolder(binding){
        private  val TAG = "TopLearnersAdapter"
        fun bind(learner: LearnersItem){
            Log.d(TAG, "bind: $learner")

            binding.textViewLearningLeadersName.text = learner.name
            binding.textViewLearningLeadersCountry.text = learner.country
            Log.d(TAG, "bind: ${binding.textViewLearningLeadersCountry.text}")
            binding.textViewLearningLeadersHours.text = "${learner.hours} Learning Hours"

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_broken_image)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(learner.badgeUrl)
                .into(binding.imageViewLearningLeaders)

        }
    }
}