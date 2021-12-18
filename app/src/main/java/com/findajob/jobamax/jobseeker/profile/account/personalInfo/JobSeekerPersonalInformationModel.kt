package com.findajob.jobamax.jobseeker.profile.account.personalInfo

import com.findajob.jobamax.model.JobSeeker
import com.parse.ParseObject

class JobSeekerPersonalInformationModel {
	var isLoaded: Boolean = false
	var recruiterId: String = ""
	var gender: String = ""
	var firstName: String = ""
	var lastName: String = ""
	var postCode: String = ""
	var dob: String = ""
	var email: String = ""
	var phoneNumber: String = ""
	var companyName: String = ""
	
	constructor() {}
	
	constructor(jobSeeker: JobSeeker) {
		this.recruiterId = jobSeeker.jobSeekerId
		this.gender = jobSeeker.gender
		this.firstName = jobSeeker.firstName
		this.lastName = jobSeeker.lastName
		this.postCode = jobSeeker.postCode
		this.dob = jobSeeker.dob
		this.email = jobSeeker.email
		this.phoneNumber = jobSeeker.phoneNumber
	}
	
	fun update(obj: ParseObject) {
		obj.put("email", email)
		obj.put("firstName", firstName)
		obj.put("lastName", lastName)
		obj.put("gender", gender)
		obj.put("dob", dob)
		obj.put("postCode", postCode)
		obj.put("phoneNumber", phoneNumber)
	}
}