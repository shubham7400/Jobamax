package com.findajob.jobamax.jobseeker.track

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.databinding.ItemJobOfferCardBinding
import com.findajob.jobamax.model.JobOffer
import com.parse.ParseObject

class JobOfferCardAdapter(val navInfo: () -> Unit) : RecyclerView.Adapter<JobOfferCardAdapter.JobOfferCardViewHolder>() {


    private val diffCallBack = object : DiffUtil.ItemCallback<ParseObject>() {
        override fun areItemsTheSame(oldItem: ParseObject, newItem: ParseObject) = oldItem.hasSameId(newItem)
        override fun areContentsTheSame(oldItem: ParseObject, newItem: ParseObject) = oldItem.updatedAt == newItem.updatedAt
    }

    private val differ = AsyncListDiffer(this, diffCallBack);

    fun submitJobOffers(jobOffers: List<ParseObject>) {
        differ.submitList(jobOffers)
    }

    inner class JobOfferCardViewHolder(val binding: ItemJobOfferCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(parseObject: ParseObject) {
            val jobOffer = JobOffer(parseObject)
            binding.offer = jobOffer
            binding.infoCard.setOnClickListener {
                navInfo()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JobOfferCardViewHolder(ItemJobOfferCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: JobOfferCardViewHolder, position: Int) = holder.bindTo(differ.currentList[position])
    override fun getItemCount() = differ.currentList.size
}
