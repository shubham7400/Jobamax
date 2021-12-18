package com.findajob.jobamax.recruiter.profile.jobOffer.create

import android.view.View

interface CreateJobOfferInterface {
	
	fun onBackButtonClicked()
	
	fun onLocationClicked()
	
	fun onUploadJobPresentationClicked()
	
	fun onLevelOfHierarchyClicked(view: View)
	
	fun onSubmitButtonClicked()
	
	fun onAddKeySkillsClicked()
	
	fun onKeySkillsClicked()
	
	fun onCityClicked()

	fun onDeleteClicked()
}