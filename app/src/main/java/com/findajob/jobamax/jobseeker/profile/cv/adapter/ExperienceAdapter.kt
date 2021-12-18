package com.findajob.jobamax.jobseeker.profile.cv.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.jobseeker.profile.cv.model.Experience
import com.findajob.jobamax.util.inflate
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.parseDisplayMonthFormat
import kotlinx.android.synthetic.main.item_experience.view.*

@SuppressLint("SetTextI18n")
class ExperienceAdapter(
    val onEditClicked: (experience: Experience) -> Unit,
    val onDeleteClicked: (experience: Experience) -> Unit,
) :
    RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Experience>() {
        override fun areItemsTheSame(oldItem: Experience, newItem: Experience): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Experience, newItem: Experience): Boolean {
            return oldItem.job == newItem.job && oldItem.company == newItem.company
        }
    }

    private val differ = AsyncListDiffer(this, diffUtil)

    fun submitExperienceList(experienceList: ArrayList<Experience>) {
        differ.submitList(experienceList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExperienceViewHolder(parent.inflate(R.layout.item_experience))

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) =
        holder.bindTo(differ.currentList[position])

    override fun getItemCount() = differ.currentList.size

    inner class ExperienceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTo(experience: Experience) {
            itemView.jobLabel.text = experience.job
            itemView.companyLabel.text = experience.company

            if (experience.location.trim().isNotEmpty())
                itemView.locationLabel.text = experience.location

            val endDate =
                if (experience.endDate.isEmpty()) "Present" else experience.endDate.parseDisplayMonthFormat()
            itemView.timeLabel.text = "${experience.startDate.parseDisplayMonthFormat()} - $endDate"

            itemView.setOnClickListener {
                log("Selected experience for editing is ${experience.job}")
                onEditClicked(experience)
            }

            itemView.editButton.setOnClickListener {
                log("Selected experience for editing is ${experience.job}")
                onEditClicked(experience)
            }

            itemView.deleteButton.setOnClickListener {
                log("Selected experience for deleting is ${experience.job}")
                onDeleteClicked(experience)
            }
        }

    }
}