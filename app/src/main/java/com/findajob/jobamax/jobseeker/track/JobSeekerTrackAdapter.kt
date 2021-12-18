package com.findajob.jobamax.jobseeker.track

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.databinding.ItemJobSeekerTrackOfferBinding
import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.model.RejectReason
import com.findajob.jobamax.util.*
import com.parse.ParseObject

class JobSeekerTrackAdapter(val node: String, ) : RecyclerView.Adapter<JobSeekerTrackAdapter.JobSeekerTrackViewHolder>() {
    private val jobOfferDiffCallback = object : DiffUtil.ItemCallback<ParseObject>() {
        override fun areItemsTheSame(oldItem: ParseObject, newItem: ParseObject) = oldItem == newItem
        override fun areContentsTheSame(oldItem: ParseObject, newItem: ParseObject) = oldItem.updatedAt == newItem.updatedAt
    }

    private val jobOfferDiffer = AsyncListDiffer(this, jobOfferDiffCallback)


    fun submitJobOffers(jobOffers: List<ParseObject>) {
        jobOfferDiffer.submitList(jobOffers)
    }

    private val reasonsDifferCallback = object : DiffUtil.ItemCallback<RejectReason>() {
        override fun areItemsTheSame(oldItem: RejectReason, newItem: RejectReason) = oldItem == newItem
        override fun areContentsTheSame(oldItem: RejectReason, newItem: RejectReason) = oldItem.reason == newItem.reason
    }

    private val reasonDiffer = AsyncListDiffer(this, reasonsDifferCallback)

    fun submitReasons(reasons: List<RejectReason>) {
        reasonDiffer.submitList(reasons)
    }

    inner class JobSeekerTrackViewHolder(val binding: ItemJobSeekerTrackOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(jobOffer: JobOffer) {
            binding.offer = jobOffer
            binding.keySillsLabel.text = jobOffer.keySkills.toPlainString()
            binding.reasonLabel.isVisible(node == NODE_REFUSED)

            when (node) {
                NODE_MATCHED -> binding.statusLabel.text = "Matched"
                NODE_REFUSED -> {
                    binding.statusLabel.text = "Refused"
                    binding.reasonLabel.text = getRejectReason(jobOffer.jobOfferId)
                }
                NODE_APPLICANTS -> binding.statusLabel.text = "Pending"
                else -> binding.statusLabel.text = ""
            }
        }
    }

    private fun getRejectReason(jobOfferId: String): String {
        return reasonDiffer.currentList.find { rr ->
            rr.jobOfferId == jobOfferId
        }?.reason ?: "-"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JobSeekerTrackViewHolder(
        ItemJobSeekerTrackOfferBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: JobSeekerTrackViewHolder, position: Int) = holder.bindTo(JobOffer(jobOfferDiffer.currentList[position]))
    override fun getItemCount() = jobOfferDiffer.currentList.size
}