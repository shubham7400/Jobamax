package com.findajob.jobamax.dashboard.home.training.masterclass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.data.pojo.Category
import com.findajob.jobamax.data.pojo.VideoThumbnail
import com.findajob.jobamax.databinding.ItemOurCategoriesBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class CategoryAdapter :
    RecyclerView.Adapter<CategoryAdapter.Holder>(),
    AutoUpdatableAdapter {

    internal var collection: List<Category> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.name == n.name }
    }

    internal var clickListener: (VideoThumbnail) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(
            parent,
        )

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val category = collection[position]
        holder.binding.apply {
            item = category
            initRv(this, category)

            executePendingBindings()
        }
    }

    private fun initRv(binding: ItemOurCategoriesBinding, category: Category) {
        binding.apply {
            val adapter = VideoThumbnailAdapter()
            adapter.clickListener = clickListener
            adapter.collection = category.thumbNail
            rv.adapter = adapter
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemOurCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemOurCategoriesBinding.inflate(inflater, parent, false)
                return Holder(
                    binding
                )
            }
        }
    }
}
