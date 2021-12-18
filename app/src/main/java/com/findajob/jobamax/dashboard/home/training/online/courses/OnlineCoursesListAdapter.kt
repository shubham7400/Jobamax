package com.findajob.jobamax.dashboard.home.training.online.courses

import androidx.paging.PagingDataAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse
import com.findajob.jobamax.databinding.ItemOnlineCoursesBinding


class OnlineCoursesListAdapter() : PagingDataAdapter<OnlineCourse, OnlineCoursesListAdapter.Holder>(DiffCallback) {


    internal var clickListener: (OnlineCourse) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
       = Holder.from(
            parent,
            R.layout.item_online_courses
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

   class Holder(val binding: ItemOnlineCoursesBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object{
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemOnlineCoursesBinding>(
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



    companion object DiffCallback : DiffUtil.ItemCallback<OnlineCourse>() {
        override fun areItemsTheSame(oldItem: OnlineCourse, newItem: OnlineCourse): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: OnlineCourse, newItem: OnlineCourse): Boolean {
            return oldItem.id == newItem.id
        }
    }

}

