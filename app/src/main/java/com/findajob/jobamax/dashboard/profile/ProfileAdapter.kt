package com.findajob.jobamax.dashboard.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.CompanyInformationTest
import com.findajob.jobamax.databinding.ItemCompanyProfileBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<CompanyInformationTest> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.icon == n.icon }
    }

    internal var clickListener: (CompanyInformationTest) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder.from(parent, R.layout.item_company_profile)

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemCompanyProfileBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemCompanyProfileBinding>(inflater, layout, parent, false)
                return Holder(binding)
            }
        }
    }
}
