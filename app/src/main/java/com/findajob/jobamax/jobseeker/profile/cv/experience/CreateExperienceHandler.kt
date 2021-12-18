package com.findajob.jobamax.jobseeker.profile.cv.experience

import android.view.View

interface CreateExperienceHandler {
    fun onSaveButtonClicked()
    fun onDateClicked(view: View, flag: Int)
    fun onBackButtonClicked()
    fun onLocationClicked()
}