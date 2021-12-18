package com.findajob.jobamax.recruiter.profile.subscription.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.databinding.ItemOfferBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class OfferAdapter : RecyclerView.Adapter<OfferAdapter.Holder>(),
    AutoUpdatableAdapter {

    internal var collection: List<String> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.hashCode() == n.hashCode() }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder.from(
        parent,
    )

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val label = collection[position]

        holder.binding.apply {
            offer = label
            executePendingBindings()
        }
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemOfferBinding.inflate(inflater, parent, false)
                return Holder(binding)
            }
        }
    }
}
