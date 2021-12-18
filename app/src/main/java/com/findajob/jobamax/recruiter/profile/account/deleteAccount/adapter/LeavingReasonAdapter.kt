package com.findajob.jobamax.recruiter.profile.account.deleteAccount.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.databinding.ItemLeavingReasonBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class LeavingReasonAdapter : RecyclerView.Adapter<LeavingReasonAdapter.Holder>(),
    AutoUpdatableAdapter {

    internal var collection: List<LeavingReason> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.hashCode() == n.hashCode() }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(parent)

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val leavingReason = collection[position]
        holder.binding.apply {
            data = leavingReason.message
            executePendingBindings()
            checkBox.setOnCheckedChangeListener { _, isChecked -> leavingReason.state = isChecked }
        }
    }

    fun fetchLeavingReason(): List<String> {
        return collection.filter { it.state }.map { it.message }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemLeavingReasonBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemLeavingReasonBinding.inflate(inflater, parent, false)
                return Holder(binding)
            }
        }
    }
}
