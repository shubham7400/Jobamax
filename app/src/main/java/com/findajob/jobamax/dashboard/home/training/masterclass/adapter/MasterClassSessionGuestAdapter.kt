package com.findajob.jobamax.dashboard.home.training.masterclass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.dashboard.home.training.masterclass.model.Guest
import com.findajob.jobamax.databinding.ItemMasterClassSessionGuestBinding

class MasterClassSessionGuestAdapter : RecyclerView.Adapter<MasterClassSessionGuestAdapter.ViewHolder>() {
    internal var clickListener: (Guest) -> Unit = { _ -> }
    var collection = emptyList<Guest>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemMasterClassSessionGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = collection[position]
        holder.binding.clGuest.setOnClickListener {
            clickListener(collection[position])
        }
    }
    override fun getItemCount(): Int = collection.size
    class ViewHolder(val binding: ItemMasterClassSessionGuestBinding) : RecyclerView.ViewHolder(binding.root)
}