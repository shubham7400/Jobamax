package com.findajob.jobamax.dashboard.home.training

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Courses
import com.findajob.jobamax.data.pojo.MyList
import com.findajob.jobamax.data.pojo.UpcomingEvents
import com.findajob.jobamax.databinding.ItemMyListBinding
import com.findajob.jobamax.databinding.ItemTrainingCoursesBinding
import com.findajob.jobamax.databinding.ItemUpcomingEventsBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class UpcomingEventsAdapter : RecyclerView.Adapter<UpcomingEventsAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<UpcomingEvents> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.event == n.event }
    }

    internal var clickListener: (UpcomingEvents) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(parent, R.layout.item_upcoming_events)

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            executePendingBindings()
//            itemHomeCvBg.setOnClickListener { clickListener(collection[position]) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemUpcomingEventsBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemUpcomingEventsBinding>(inflater, layout, parent, false)
                return Holder(binding)
            }
        }
    }
}
