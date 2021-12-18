package com.findajob.jobamax.jobseeker.source

import android.view.View

interface JobSourceInterface {
	
	fun onAddLocationClicked()
	
	fun onAddExperienceClicked()
	
	fun onAddEducationClicked()
	
	fun onAddKeySkillClicked()
	
	fun onCityClicked()
	
	fun onSubmitButtonClicked()
	
	fun onBackButtonClicked()
	
	fun onResetClicked()
}