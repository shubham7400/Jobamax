package com.findajob.jobamax.jobseeker.profile.jobSearch

import android.view.View

interface JobSearchInterface {
	
	fun onBackButtonClicked()
	
	fun onLocationClicked()
	
	fun onTemporaryPermanentClicked(view: View)
	
	fun onSubmitButtonClicked()
	
	fun onResetClicked()
}