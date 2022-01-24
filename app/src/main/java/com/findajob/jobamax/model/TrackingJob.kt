package com.findajob.jobamax.model

import com.findajob.jobamax.enums.ParseTableName
import com.parse.ParseObject
import java.io.Serializable

class TrackingJob : Serializable {
    var jobSeeker: ParseObject? = null
    var job: ParseObject? = null
    var jobSeekerId: String = ""
    var phases: String = ""
    var pfObject: ParseObject? = null

    fun toParseObject(): ParseObject {
        val trackingJob = ParseObject(ParseTableName.TrackingJob.toString())
        jobSeeker?.let { trackingJob.put("jobSeeker", it) }
        job?.let { trackingJob.put("job", it) }
        trackingJob.put("JobSeekerId", jobSeekerId)
        trackingJob.put("phases", phases)
        pfObject?.let { trackingJob.put("pfObject", it) }
        return trackingJob
    }

    constructor(obj: ParseObject) {
        this.jobSeeker = obj.getParseObject("jobSeeker")
        this.job = obj.getParseObject("job")
        this.jobSeekerId =   obj["JobSeekerId"]?.toString() ?: ""
        this.phases =  obj["phases"]?.toString() ?: ""
        this.pfObject = obj
    }

    constructor()
}