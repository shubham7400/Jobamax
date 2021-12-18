package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.review

import androidx.paging.PagingDataAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review
import com.findajob.jobamax.databinding.ItemOnlineCourseReviewBinding


class ReviewsListAdapter() : PagingDataAdapter<Review, ReviewsListAdapter.Holder>(DiffCallback) {


    internal var clickListener: (Review) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = Holder.from(
            parent,
            R.layout.item_online_course_review
    )


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = getItem(position)
            executePendingBindings()
            itemHomeCvBg.setOnClickListener { getItem(position)?.let { it1 -> clickListener(it1) } }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemOnlineCourseReviewBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object{
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemOnlineCourseReviewBinding>(
                        inflater,
                        layout,
                        parent,
                        false
                )
                return Holder(
                        binding
                )
            }
        }

    }



    companion object DiffCallback : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem.id == newItem.id
        }
    }

}

