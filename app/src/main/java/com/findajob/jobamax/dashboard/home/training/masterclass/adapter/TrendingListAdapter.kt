package com.findajob.jobamax.dashboard.home.training.masterclass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.data.pojo.Category
import com.findajob.jobamax.data.pojo.VideoThumbnail
import com.findajob.jobamax.databinding.ItemOurCategoriesBinding
import com.findajob.jobamax.databinding.ItemVideoThumbnailBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class TrendingListAdapter : RecyclerView.Adapter<TrendingListAdapter.Holder>(), AutoUpdatableAdapter {
    internal var collection = emptyList<Category>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(ItemVideoThumbnailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val category = collection[position]
        holder.binding.apply {
            item = category
            /*initRv(this, category)*/
            itemOurCategoriesIvThumbnail.setOnClickListener {
                clickListener(category)
            }
            executePendingBindings()
        }
    }

   /* private fun initRv(binding: ItemVideoThumbnailBinding, category: Category) {
        binding.apply {
            val adapter = VideoThumbnailAdapter()
            adapter.clickListener = clickListener
            *//*adapter.collection = *//**//*category.topicThumbnail*//**//* *//*
           *//* rv.adapter = adapter*//*
        }
    }*/

    internal var clickListener: (Category) -> Unit = { _ -> }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemVideoThumbnailBinding) : RecyclerView.ViewHolder(binding.root)
}
