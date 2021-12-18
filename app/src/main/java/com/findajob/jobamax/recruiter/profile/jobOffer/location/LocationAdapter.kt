package com.findajob.jobamax.recruiter.profile.jobOffer.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Location
import com.findajob.jobamax.databinding.ItemLocationBinding
import com.findajob.jobamax.util.log

class LocationAdapter(val onLocationSelected: (location: Location) -> Unit) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Location, newItem: Location) =
            oldItem == newItem

    }

    val differ = AsyncListDiffer(this, diffCallBack)

    fun submitLocationList(locations: List<Location>?) {
        locations?.let {
            log("location list ${this::class.java.simpleName} -> $locations")
            differ.submitList(locations)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val layout = R.layout.item_location

        val binding =
            DataBindingUtil.inflate<ItemLocationBinding>(inflater, layout, parent, false)

        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {

        val location = differ.currentList[position]

        log("location in ${this::class.java.simpleName} -> $location")

        holder.binding.cityLabel.text = location.address
        holder.binding.root.setOnClickListener {
            onLocationSelected(location)
        }
    }

    override fun getItemCount() = differ.currentList.size

    inner class LocationViewHolder(val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root)
}