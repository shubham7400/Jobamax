package com.findajob.jobamax.model

import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.parse.ParseObject
import java.io.Serializable

class TrackingJob : Serializable {
    @Transient
    var jobSeeker: ParseObject? = null
    var job: ParseObject? = null
    var jobSeekerId: String = ""
    var phases: String = ""
    var isSelected: Boolean = false
    @Transient
    var pfObject: ParseObject? = null

    fun toParseObject(): ParseObject {
        val trackingJob = ParseObject(ParseTableName.TRACKING_JOB.value)
        jobSeeker?.let { trackingJob.put("jobSeeker", it) }
        job?.let { trackingJob.put("job", it) }
        trackingJob.put(ParseTableFields.JOB_SEEKER_ID.value, jobSeekerId)
        trackingJob.put("phases", phases)
        trackingJob.put("isSelected", isSelected)
        pfObject?.let { trackingJob.put("pfObject", it) }
        return trackingJob
    }

    constructor(obj: ParseObject) {
        this.jobSeeker = obj.getParseObject("jobSeeker")
        this.job = obj.getParseObject("job")
        this.jobSeekerId =   obj["JobSeekerId"]?.toString() ?: ""
        this.phases =  obj["phases"]?.toString() ?: ""
        this.isSelected =  obj.getBoolean("isSelected")
        this.pfObject = obj
    }

    constructor()
}