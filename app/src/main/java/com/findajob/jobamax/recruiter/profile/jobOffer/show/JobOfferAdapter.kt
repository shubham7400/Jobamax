package com.findajob.jobamax.recruiter.profile.jobOffer.show

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.util.inflate
import com.parse.ParseObject
import kotlinx.android.synthetic.main.item_job_offer.view.*

class JobOfferAdapter(
    val navViewOffer: (offer: ParseObject) -> Unit
) : RecyclerView.Adapter<JobOfferAdapter.JobOfferViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<ParseObject>() {
        override fun areItemsTheSame(oldItem: ParseObject, newItem: ParseObject) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ParseObject, newItem: ParseObject) =
            oldItem.updatedAt == newItem.updatedAt
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(jobOffers: List<ParseObject>) {
        differ.submitList(jobOffers)
    }

    inner class JobOfferViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTo(jobOfferPo: ParseObject) {
            val jobOffer = JobOffer(jobOfferPo)
            if (jobOffer.isArchived) itemView.tv_job_name.setTextColor(Color.GRAY)
            itemView.tv_job_name.text = jobOffer.name
            itemView.setOnClickListener {
                navViewOffer(jobOfferPo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        JobOfferViewHolder(parent.inflate(R.layout.item_job_offer))

    override fun onBindViewHolder(holder: JobOfferViewHolder, position: Int) =
        holder.bindTo(differ.currentList[position])

    override fun getItemCount() = differ.currentList.size
}


class JobOfferFilterAdapter(
    val navViewOffer: (offer: ParseObject) -> Unit
) : RecyclerView.Adapter<JobOfferFilterAdapter.JobOfferFilterViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<ParseObject>() {
        override fun areItemsTheSame(oldItem: ParseObject, newItem: ParseObject) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ParseObject, newItem: ParseObject) =
            oldItem.updatedAt == newItem.updatedAt
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(jobOffers: List<ParseObject>) {
        differ.submitList(jobOffers)
    }

    inner class JobOfferFilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTo(jobOfferPo: ParseObject) {
            val jobOffer = JobOffer(jobOfferPo)

            // hides the job offers which are archived from the filter
            if (jobOffer.isArchived) {
                itemView.visibility = View.GONE
                itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
            }

            itemView.tv_job_name.text = jobOffer.name
            itemView.setOnClickListener {
                navViewOffer(jobOfferPo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        JobOfferFilterViewHolder(parent.inflate(R.layout.item_job_offer))

    override fun onBindViewHolder(holder: JobOfferFilterViewHolder, position: Int) =
        holder.bindTo(differ.currentList[position])

    override fun getItemCount() = differ.currentList.size
}