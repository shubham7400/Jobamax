package com.findajob.jobamax.dashboard.home.training.masterclass.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.masterclass.model.Episode
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClassVideo
import com.findajob.jobamax.databinding.ItemMasterclassVideoBinding
import com.findajob.jobamax.databinding.ItemVideoThumbnailBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class VideoEpisodeAdapter : RecyclerView.Adapter<VideoEpisodeAdapter.Holder>(){
    var selectedPosition = -1
    internal var collection = emptyList<Episode>()
    internal var clickListener: (Episode) -> Unit = { _ -> }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(ItemMasterclassVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = collection.size
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            if (selectedPosition == position){
                holder.itemView.setBackgroundResource(R.color.purple)
            }else{
                holder.itemView.setBackgroundResource(R.color.transparent)
            }
            executePendingBindings()
            clItemMasterVideo.setOnClickListener {
                selectedPosition = position
                clickListener(collection[position])
                notifyDataSetChanged()
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    class Holder(val binding: ItemMasterclassVideoBinding): RecyclerView.ViewHolder(binding.root)
}