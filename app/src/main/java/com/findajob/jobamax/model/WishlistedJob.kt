package com.findajob.jobamax.model

import com.findajob.jobamax.enums.ParseTableName
import com.parse.ParseObject

class WishlistedJob {
    var jobSeeker: ParseObject? = null
    var job: ParseObject? = null
    var isFavroite: Boolean = false
    var isArchived: Boolean = false
    var pfObject: ParseObject? = null

    fun toParseObject(): ParseObject {
        val wishlistedJob = ParseObject(ParseTableName.WishlistedJob.toString())
        jobSeeker?.let { wishlistedJob.put("jobSeeker", it) }
        job?.let { wishlistedJob.put("job", it) }
        wishlistedJob.put("isFavroite", isFavroite)
        wishlistedJob.put("isArchived", isArchived)
        pfObject?.let { wishlistedJob.put("pfObject", it) }
        return wishlistedJob
    }

    constructor(obj: ParseObject) {
        this.jobSeeker = obj.getParseObject("jobSeeker")
        this.job = obj.getParseObject("job")
        this.isFavroite = obj.getBoolean("isFavroite")
        this.isArchived = obj.getBoolean("isArchived")
        this.pfObject = obj
    }

    constructor()
}