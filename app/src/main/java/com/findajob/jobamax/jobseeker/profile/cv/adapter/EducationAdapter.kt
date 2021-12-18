package com.findajob.jobamax.jobseeker.profile.cv.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.util.inflate
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.parseDisplayMonthFormat
import kotlinx.android.synthetic.main.item_education.view.*

@SuppressLint("SetTextI18n")
class EducationAdapter(
    val onEditClicked: (education: Education) -> Unit,
    val onDeleteClicked: (education: Education) -> Unit,
) :
    RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Education>() {
        override fun areItemsTheSame(oldItem: Education, newItem: Education): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Education, newItem: Education): Boolean {
            return oldItem.name == newItem.name && oldItem.endDate == newItem.endDate && oldItem.gpa == newItem.gpa
        }

    }

    private val differ = AsyncListDiffer(this, diffUtil)

    fun submitEducationList(educationList: ArrayList<Education>) {
        differ.submitList(educationList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EducationViewHolder(parent.inflate(R.layout.item_education))

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) =
        holder.bindTo(differ.currentList[position])

    override fun getItemCount() = differ.currentList.size

    inner class EducationViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTo(education: Education) {
            itemView.tv_name_label.text = education.name
            itemView.tv_program_label.text = education.program
            itemView.tv_time_label.text =
                education.startDate.parseDisplayMonthFormat() + " - " + education.endDate.parseDisplayMonthFormat()
            itemView.tv_gpa.text = "GPA: ${education.gpa}"

            itemView.setOnClickListener {
                log("Selected education for editing is ${education.name}")
                onEditClicked(education)
            }

            itemView.iv_edit_button.setOnClickListener {
                log("Selected education for editing is ${education.name}")
                onEditClicked(education)
            }

            itemView.iv_delete_button.setOnClickListener {
                log("Selected education for deleting is ${education.name}")
                onDeleteClicked(education)
            }
        }

    }
}