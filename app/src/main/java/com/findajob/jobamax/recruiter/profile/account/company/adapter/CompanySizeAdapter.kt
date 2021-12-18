package com.findajob.jobamax.recruiter.profile.account.company.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.databinding.ItemCompanySizeBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class CompanySizeAdapter : RecyclerView.Adapter<CompanySizeAdapter.Holder>(),
    AutoUpdatableAdapter {

    internal var collection: List<CompanySize> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.hashCode() == n.hashCode() }
    }

    internal var clickListener: (CompanySize) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder.from(
        parent
    )

    private var prevItem: CompanySize? = null

    var selectedItem: CompanySize? = null

    private lateinit var context: Context

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            context = root.context

            val companySize = collection[position]
            item = companySize
            container.setOnClickListener {
                if (!radio.isChecked) {
                    selectedItem = companySize

                    updateSelected(companySize, position)
                    updatePrevious(companySize)

                    clickListener(companySize)
                }
            }
            executePendingBindings()
        }
    }

    fun selectedSize(label: String) {
        selectedItem = collection.find { it.label == label }
        selectedItem?.status = true
        selectedItem?.let {
            prevItem = it
            notifyItemChanged(collection.indexOf(it))
        }
    }

    private fun updateSelected(companySize: CompanySize, position: Int) {
        companySize.status = true
        notifyItemChanged(position)
    }

    private fun updatePrevious(companySize: CompanySize) {
        prevItem?.status = false
        prevItem?.let {
            notifyItemChanged(collection.indexOf(it))
        }
        if (prevItem != companySize) {
            prevItem = companySize
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class Holder(val binding: ItemCompanySizeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemCompanySizeBinding.inflate(inflater, parent, false)
                return Holder(binding)
            }
        }
    }
}
