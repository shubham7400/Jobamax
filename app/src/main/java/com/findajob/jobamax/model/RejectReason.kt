package com.findajob.jobamax.model

import com.parse.ParseObject

class RejectReason {
	
	//var reasonId: String = UUID.randomUUID().toString()
	var jobSeekerId: String = ""
	var jobOfferId: String = ""
	var reason: String = ""
	
	constructor()
	
	constructor(obj: ParseObject) {
		//this.reasonId = obj["reasonId"].toString()
		this.jobSeekerId = obj["jobSeekerId"].toString()
		this.jobOfferId = obj["jobOfferId"].toString()
		this.reason = obj["reason"].toString()
	}
	
	fun toParseObject(): ParseObject {
		val company = ParseObject("RejectReason")
		//company.put("reasonId", reasonId)
		company.put("jobSeekerId", jobSeekerId)
		company.put("jobOfferId", jobOfferId)
		company.put("reason", reason)
		return company
	}
	
	fun update(obj: ParseObject) {
		//obj.put("reasonId", reasonId)
		obj.put("jobSeekerId", jobSeekerId)
		obj.put("jobOfferId", jobOfferId)
		obj.put("reason", reason)
	}
}