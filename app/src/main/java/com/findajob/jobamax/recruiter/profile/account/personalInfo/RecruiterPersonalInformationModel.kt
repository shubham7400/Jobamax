package com.findajob.jobamax.recruiter.profile.account.personalInfo

import com.findajob.jobamax.model.Company
import com.findajob.jobamax.model.Recruiter
import com.parse.ParseObject

class RecruiterPersonalInformationModel {
	var recruiterId: String = ""
	var gender: String = ""
	var firstName: String = ""
	var lastName: String = ""
	var postCode: String = ""
	var email: String = ""
	var phoneNumber: String = ""
	var companyName: String = ""
	var dob: String = ""
	var password: String = ""
	
	constructor() {}
	
	constructor(recruiter: Recruiter, company: Company) {
		this.recruiterId = recruiter.recruiterId
		this.gender = recruiter.gender
		this.firstName = recruiter.firstName
		this.lastName = recruiter.lastName
		this.postCode = recruiter.postCode
		this.email = recruiter.email
		this.phoneNumber = recruiter.phoneNumber
		this.companyName = company.name
		this.dob = recruiter.dob
	}
	
	fun update(obj: ParseObject) {
		obj.put("email", email)
		obj.put("firstName", firstName)
		obj.put("lastName", lastName)
		obj.put("gender", gender)
		obj.put("postCode", postCode)
		obj.put("phoneNumber", phoneNumber)
		obj.put("dob", dob)
	}

}