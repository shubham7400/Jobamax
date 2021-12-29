package com.findajob.jobamax.dashboard.home.training.masterclass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.data.pojo.VideoThumbnail
import com.findajob.jobamax.databinding.ItemVideoThumbnailBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class VideoThumbnailAdapter : RecyclerView.Adapter<VideoThumbnailAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<VideoThumbnail> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.hashCode() == n.hashCode() }
    }

    internal var clickListener: (VideoThumbnail) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(ItemVideoThumbnailBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val videoThumbnail = collection[position]
        holder.binding.apply {
           /* item = videoThumbnail*/
            root.setOnClickListener {
                clickListener(videoThumbnail)
            }
            executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemVideoThumbnailBinding) : RecyclerView.ViewHolder(binding.root)
}
