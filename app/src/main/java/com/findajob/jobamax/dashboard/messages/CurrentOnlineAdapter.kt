package com.findajob.jobamax.dashboard.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.CurrentOnline
import com.findajob.jobamax.databinding.ItemCurrentOnlineBinding
import javax.inject.Inject

class CurrentOnlineAdapter @Inject constructor() :
    RecyclerView.Adapter<CurrentOnlineAdapter.Holder>() {


    private val diffCallBack = object : DiffUtil.ItemCallback<CurrentOnline>() {
        override fun areItemsTheSame(oldItem: CurrentOnline, newItem: CurrentOnline) =
            oldItem.objectId == newItem.objectId

        override fun areContentsTheSame(oldItem: CurrentOnline, newItem: CurrentOnline) =
            oldItem.name == newItem.name && oldItem.profilePicUrl == newItem.profilePicUrl
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(currentOnlineList: List<CurrentOnline>) {
        differ.submitList(currentOnlineList)
    }


    internal var clickListener: (CurrentOnline) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(
            parent,
            R.layout.item_current_online
        )

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val currentOnline = differ.currentList[position]

        holder.binding.apply {
            item = currentOnline.apply {
                if (sourcedOrMatched == "sourced") {
                    ivSourcedMatched.load(R.drawable.ic_top_arrow)
                } else {
                    ivSourcedMatched.load(R.drawable.ic_messenger_chat)
                }
            }
            executePendingBindings()

            itemCurrentOnlineCvOnline.setOnClickListener { clickListener(currentOnline) }

        }
    }

    override fun getItemViewType(position: Int) = position

    class Holder(val binding: ItemCurrentOnlineBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemCurrentOnlineBinding>(
                    inflater,
                    layout,
                    parent,
                    false
                )
                return Holder(
                    binding
                )
            }
        }
    }
}
