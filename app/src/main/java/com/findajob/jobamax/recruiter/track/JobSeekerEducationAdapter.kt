package com.findajob.jobamax.recruiter.track

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.util.inflate
import kotlinx.android.synthetic.main.item_job_seeker_school.view.*

class JobSeekerEducationAdapter(val educations: List<Education>) : RecyclerView.Adapter<JobSeekerEducationAdapter.JobSeekerEducationViewHolder>() {
	
	inner class JobSeekerEducationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		fun bindTo(education: Education) {
			itemView.schoolNameLabel.text = education.name
			itemView.programLabel.text = education.program
			itemView.timeLabel.text = education.startDate + " - " + education.endDate
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JobSeekerEducationViewHolder(parent.inflate(R.layout.item_job_seeker_school))
	
	override fun onBindViewHolder(holder: JobSeekerEducationViewHolder, position: Int) = holder.bindTo(educations[position])
	
	override fun getItemCount() = educations.size
}