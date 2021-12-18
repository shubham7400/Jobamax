package com.findajob.jobamax.jobseeker.profile.info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.databinding.ItemInfoBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class InfoAdapter : RecyclerView.Adapter<InfoAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<Info> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.pos == n.pos }
    }

//    internal var clickListener: (Courses) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(parent)

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            data = collection[position]
            executePendingBindings()
//            itemHomeClBg.setOnClickListener { clickListener(collection[position]) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemInfoBinding.inflate(inflater, parent, false)
                return Holder(binding)
            }
        }
    }
}
