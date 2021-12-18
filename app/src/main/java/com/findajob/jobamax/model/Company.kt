package com.findajob.jobamax.model

import com.parse.ParseObject
import java.util.*

class Company {
	
	var companyId: String = UUID.randomUUID().toString()
	var recruiterId: String = ""
	var name: String = ""
	var position: String = ""
	var companyWebsite: String = ""
	var companySize:String = ""
	var regNumber: String = ""
	var vatNumber: String = ""
	var headquarterAddress: String = ""
	var logoUrl: String = ""
	var videoPresentationUrl: String = ""
	var videoPresentationThumbLink: String = ""
	
	constructor()
	
	constructor(obj: ParseObject) {
		this.companyId = obj["companyId"].toString()
		this.recruiterId = obj["recruiterId"].toString()
		this.name = obj["name"].toString()
		this.regNumber = obj["regNumber"].toString()
		this.vatNumber = obj["vatNumber"].toString()
		this.headquarterAddress = obj["headquarterAddress"].toString()
		this.logoUrl = obj["logoUrl"].toString()
		this.videoPresentationUrl = obj["videoPresentationUrl"].toString()
		this.videoPresentationThumbLink = obj["videoPresentationThumbLink"].toString()
		this.companySize = obj["companySize"].toString()
		this.companyWebsite = obj["companyWebsite"].toString()
	}
	
	fun toParseObject(): ParseObject {
		val company = ParseObject("Company")
		company.put("companyId", companyId)
		company.put("recruiterId", recruiterId)
		company.put("name", name)
		company.put("regNumber", regNumber)
		company.put("vatNumber", vatNumber)
		company.put("headquarterAddress", headquarterAddress)
		company.put("logoUrl", logoUrl)
		company.put("videoPresentationUrl", videoPresentationUrl)
		company.put("videoPresentationThumbLink", videoPresentationThumbLink)
		company.put("companySize", companySize)
		company.put("companyWebsite", companyWebsite)
		return company
	}
	
	fun update(obj:ParseObject){
		obj.put("regNumber", regNumber)
		obj.put("position", position)
		obj.put("vatNumber", vatNumber)
		obj.put("name", name)
		obj.put("headquarterAddress", headquarterAddress)
		obj.put("companySize", companySize)
		obj.put("companyWebsite", companyWebsite)
	}

	companion object{
		const val CLASS_NAME="company"
	}
}