package com.findajob.jobamax.recruiter.profile.jobOffer.create

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.util.benefitsList
import com.findajob.jobamax.util.inflate
import kotlinx.android.synthetic.main.item_select_benefits.view.*

class SelectBenefitsAdapter(benefits: List<String>) : RecyclerView.Adapter<SelectBenefitsAdapter.BenefitsViewHolder>() {
	
	private var checkedList = booleanArrayOf()
	
	init {
		checkedList = benefitsList.map { benefits.contains(it) }.toBooleanArray()
	}
	
	fun getBenefits() = benefitsList.filterIndexed { index, s -> checkedList[index] }
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BenefitsViewHolder(parent.inflate(R.layout.item_select_benefits))
	
	override fun onBindViewHolder(holder: BenefitsViewHolder, position: Int) {
		holder.bindTo(benefitsList[position])
	}
	
	override fun getItemCount() = benefitsList.size
	
	inner class BenefitsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		fun bindTo(benefit: String) {
			itemView.benefitLabel.text = benefit
			itemView.benefitLabel.isChecked = checkedList[adapterPosition]
			itemView.benefitLabel.setOnCheckedChangeListener { compoundButton, b ->
				checkedList[adapterPosition] = b
			}
		}
	}
}