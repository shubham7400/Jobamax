package com.jobamax.appjobamax.jobseeker.model

import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.parse.ParseObject
import java.io.Serializable

class TrackingOtherJob : Serializable {
    @Transient
    var jobSeeker: ParseObject? = null
    var jobSeekerId: String = ""
    var phases: String = ""
    var companyName: String = ""
    var city: String = ""
    var jobTitle: String = ""
    var description: String = ""
    var isSelected: Boolean = false
    @Transient
    var pfObject: ParseObject? = null

    fun toParseObject(): ParseObject {
        val trackingOtherJob = ParseObject(ParseTableName.PERSONAL_TRACK_JOB.value)
        jobSeeker?.let { trackingOtherJob.put("jobSeeker", it) }
        trackingOtherJob.put(ParseTableFields.JOB_SEEKER_ID.value, jobSeekerId)
        trackingOtherJob.put("phases", phases)
        trackingOtherJob.put("companyName", companyName)
        trackingOtherJob.put("city", city)
        trackingOtherJob.put("jobTitle", jobTitle)
        trackingOtherJob.put("description", description)
        trackingOtherJob.put("isSelected", isSelected)
        pfObject?.let { trackingOtherJob.put("pfObject", it) }
        return trackingOtherJob
    }

    constructor(obj: ParseObject) {
        this.jobSeeker = obj.getParseObject("jobSeeker")
        this.jobSeekerId =   obj["JobSeekerId"]?.toString() ?: ""
        this.phases =  obj["phases"]?.toString() ?: ""
        this.companyName =  obj["companyName"]?.toString() ?: ""
        this.city =  obj["city"]?.toString() ?: ""
        this.jobTitle =  obj["jobTitle"]?.toString() ?: ""
        this.description =  obj["description"]?.toString() ?: ""
        this.isSelected =  obj.getBoolean("isSelected")
        this.pfObject = obj
    }

    constructor()

}