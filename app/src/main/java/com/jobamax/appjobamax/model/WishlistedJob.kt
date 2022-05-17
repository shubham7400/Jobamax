package com.jobamax.appjobamax.model

import com.jobamax.appjobamax.enums.ParseTableName
import com.parse.ParseObject

class WishlistedJob {
    var jobSeeker: ParseObject? = null
    var job: ParseObject? = null
    var isFavroite: Boolean = false
    var isArchived: Boolean = false
    var isAddedToTracking: Boolean = false
    var pfObject: ParseObject? = null

    fun toParseObject(): ParseObject {
        val wishlistedJob = ParseObject(ParseTableName.WISHLISTED_JOB.value)
        jobSeeker?.let { wishlistedJob.put("jobSeeker", it) }
        job?.let { wishlistedJob.put("job", it) }
        wishlistedJob.put("isFavroite", isFavroite)
        wishlistedJob.put("isArchived", isArchived)
        wishlistedJob.put("isAddedToTracking", isAddedToTracking)
        pfObject?.let { wishlistedJob.put("pfObject", it) }
        return wishlistedJob
    }

    constructor(obj: ParseObject) {
        this.jobSeeker = obj.getParseObject("jobSeeker")
        this.job = obj.getParseObject("job")
        this.isFavroite = obj.getBoolean("isFavroite")
        this.isArchived = obj.getBoolean("isArchived")
        this.isAddedToTracking = obj.getBoolean("isAddedToTracking")
        this.pfObject = obj
    }

    constructor()
}