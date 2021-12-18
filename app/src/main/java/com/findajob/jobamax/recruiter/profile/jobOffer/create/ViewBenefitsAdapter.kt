package com.findajob.jobamax.recruiter.profile.jobOffer.create

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.util.inflate
import kotlinx.android.synthetic.main.item_view_benefits.view.*

class ViewBenefitsAdapter(var benefits: List<String>) : RecyclerView.Adapter<ViewBenefitsAdapter.BenefitsViewHolder>() {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BenefitsViewHolder(parent.inflate(R.layout.item_view_benefits))
	
	override fun onBindViewHolder(holder: BenefitsViewHolder, position: Int) {
		holder.bindTo(benefits[position])
	}
	
	override fun getItemCount() = benefits.size
	
	inner class BenefitsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		fun bindTo(benefit: String) {
			itemView.benefitLabel.text = benefit
			itemView.benefitLabel.isEnabled = false
		}
	}
}