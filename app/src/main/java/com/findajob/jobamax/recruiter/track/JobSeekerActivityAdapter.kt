package com.findajob.jobamax.recruiter.track

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.util.inflate
import kotlinx.android.synthetic.main.item_activity.view.*

class JobSeekerActivityAdapter(val activities: List<String>) : RecyclerView.Adapter<JobSeekerActivityAdapter.JobSeekerExperienceViewHolder>() {
	
	inner class JobSeekerExperienceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		fun bindTo(activity: String) {
			itemView.label.text = activity
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JobSeekerExperienceViewHolder(parent.inflate(R.layout.item_activity))
	
	override fun onBindViewHolder(holder: JobSeekerExperienceViewHolder, position: Int) = holder.bindTo(activities[position])
	
	override fun getItemCount() = activities.size
}