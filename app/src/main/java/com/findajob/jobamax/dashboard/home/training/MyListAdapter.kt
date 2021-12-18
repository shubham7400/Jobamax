package com.findajob.jobamax.dashboard.home.training

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClass
import com.findajob.jobamax.databinding.ItemMasterClassBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class MyListAdapter : RecyclerView.Adapter<MyListAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<MasterClass> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    internal var clickListener: (MasterClass) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(parent, R.layout.item_master_class)

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            executePendingBindings()
            cdMasterClass.setOnClickListener { clickListener(collection[position]) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemMasterClassBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemMasterClassBinding>(inflater, layout, parent, false)
                return Holder(binding)
            }
        }
    }
}
