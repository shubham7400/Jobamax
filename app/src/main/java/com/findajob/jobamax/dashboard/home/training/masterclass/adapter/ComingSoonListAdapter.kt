package com.findajob.jobamax.dashboard.home.training.masterclass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.data.pojo.Category
import com.findajob.jobamax.databinding.ItemOurCategoriesBinding
import com.findajob.jobamax.databinding.ItemVideoThumbnailBinding

class ComingSoonListAdapter : RecyclerView.Adapter<ComingSoonListAdapter.Holder>() {
    internal var collection = emptyList<Category>()
    internal var clickListener: (Category) -> Unit = { _ -> }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(ItemVideoThumbnailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            itemOurCategoriesIvThumbnail.setOnClickListener {
                clickListener(collection[position])
            }
        }
    }
    override fun getItemCount(): Int  = collection.size
    class Holder(val binding: ItemVideoThumbnailBinding) : RecyclerView.ViewHolder(binding.root)
}