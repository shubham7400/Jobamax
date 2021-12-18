package com.findajob.jobamax.jobseeker.profile.account.personalInfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findajob.jobamax.model.GetUserCallback
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.repo.JobSeekerRepo
import com.parse.ParseException
import com.parse.ParseObject

class JobSeekerPersonalIntroInfoViewModel(val context: Application) : AndroidViewModel(context) {
	
	private val jobSeekerRepo = JobSeekerRepo(context)
	private var jobSeekerObject: ParseObject? = null
	private val jobSeekerLiveData = MutableLiveData<JobSeeker>()
	
	fun getJobSeekerObserver(): LiveData<JobSeeker> = jobSeekerLiveData
	
	val jobSeeker get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)
	
	fun getJobSeeker() {
		jobSeekerRepo.getCurrent(object : GetUserCallback {
			override fun onSuccess(parseObject: ParseObject) {
				jobSeekerObject = parseObject
				jobSeekerLiveData.value = jobSeeker
			}
			override fun onFailure(e: Exception?) {
			}
		})
	}
	
	fun submitData(personalInfoModel: JobSeekerPersonalInformationModel, callback: (it: ParseException?) -> Unit) {
		personalInfoModel.update(jobSeekerObject!!)
		val user = jobSeekerObject!!.getParseObject("user")
		user!!.put("lastName", jobSeekerObject!!.get("lastName")!!)
		user.put("firstName", jobSeekerObject!!.get("firstName")!!)
		user.put("email", jobSeekerObject!!.get("email")!!)
		user.put("username", jobSeekerObject!!.get("email")!!)
		user.saveInBackground()
		jobSeekerObject?.saveInBackground {
			callback(it)
		}
	}
}