package com.findajob.jobamax.recruiter.track

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.jobseeker.profile.cv.model.Experience
import com.findajob.jobamax.util.inflate
import kotlinx.android.synthetic.main.item_job_seeker_experience.view.*

class JobSeekerExperienceAdapter(val experiences: List<Experience>) : RecyclerView.Adapter<JobSeekerExperienceAdapter.JobSeekerExperienceViewHolder>() {
	
	inner class JobSeekerExperienceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		fun bindTo(experience: Experience) {
			itemView.companyLabel.text = experience.company
			itemView.jobLabel.text = experience.job
			itemView.timeLabel.text = experience.startDate + " - " + experience.endDate
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JobSeekerExperienceViewHolder(parent.inflate(R.layout.item_job_seeker_experience))
	
	override fun onBindViewHolder(holder: JobSeekerExperienceViewHolder, position: Int) = holder.bindTo(experiences[position])
	
	override fun getItemCount() = experiences.size
}