package com.findajob.jobamax.dashboard.home.training.masterclass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClassVideo
import com.findajob.jobamax.databinding.ItemMasterclassVideoBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class VideoDetailsAdapter : RecyclerView.Adapter<VideoDetailsAdapter.Holder>(), AutoUpdatableAdapter{

    internal var collection: List<MasterClassVideo> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    internal var clickListener: (MasterClassVideo) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
        = Holder.from(
        parent,
        R.layout.item_masterclass_video
    )

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            executePendingBindings()
            clItemMasterVideo.setOnClickListener { clickListener(collection[position]) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class Holder(val binding: ItemMasterclassVideoBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemMasterclassVideoBinding>(inflater, layout, parent, false)
                return Holder(binding)
            }
        }
    }
}