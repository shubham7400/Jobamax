package com.findajob.jobamax.jobseeker.profile.cv.education

import android.view.View

interface CreateEducationHandler {
    fun onAddEducationClicked()

    fun onDateClicked(view: View, flag: Int)

    fun onBackButtonClicked()
}