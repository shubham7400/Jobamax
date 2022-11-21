package com.jobamax.appjobamax.jobseeker.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.parse.ParseObject

class BuildProfileViewModel : ViewModel(){

    var jobSeekerObject: ParseObject? = null
    val jobSeeker get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)
    var isJobSeekerUpdated = MutableLiveData<Boolean>()

}