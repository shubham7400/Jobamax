package com.findajob.jobamax.training.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ItemEventBinding
import com.findajob.jobamax.model.Event
import com.findajob.jobamax.util.log
import com.parse.ParseObject
import javax.inject.Inject

class EventAdapter @Inject constructor() : RecyclerView.Adapter<EventAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(
            parent,
            R.layout.item_event
        )


    private val diffCallback = object : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oi: Event, ni: Event) = oi == ni
        override fun areContentsTheSame(oi: Event, ni: Event) = oi.name == ni.name
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun getItemCount(): Int = differ.currentList.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {

            val selectedEvent = differ.currentList[position].also {
                log("Current event that is being viewed is $it")
            }

            event = selectedEvent.apply {
                organiser?.fetchIfNeeded<ParseObject>()
                val dayOfMonth = date.date
                tvDate.text = dayOfMonth.toString()
            }
            executePendingBindings()
        }
    }

    class Holder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemEventBinding>(
                    inflater,
                    layout,
                    parent,
                    false
                )
                return Holder(binding)
            }
        }

    }
}