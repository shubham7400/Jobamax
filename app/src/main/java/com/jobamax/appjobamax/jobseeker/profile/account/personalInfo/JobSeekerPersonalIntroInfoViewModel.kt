package com.jobamax.appjobamax.jobseeker.profile.account.personalInfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
 import com.jobamax.appjobamax.model.JobSeeker
 import com.parse.ParseObject

class JobSeekerPersonalIntroInfoViewModel(val context: Application) : AndroidViewModel(context) {
	

	private var jobSeekerObject: ParseObject? = null
	private val jobSeekerLiveData = MutableLiveData<JobSeeker>()
	
	fun getJobSeekerObserver(): LiveData<JobSeeker> = jobSeekerLiveData
	
	val jobSeeker get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)
 }