package com.jobamax.appjobamax.data.pojo

import com.jobamax.appjobamax.enums.ParseTableName
import com.parse.ParseObject

class IdealJob(obj: ParseObject) {
    var text: String = ""
    var arrImages = ArrayList<String>()
    var audioUrl: String = ""
    var videoURL: String = ""
    var jobSeeker: ParseObject? = null
    var pfObject: ParseObject? = obj

    fun toParseObject(): ParseObject {
        val idealJob = ParseObject(ParseTableName.IDEAL_JOB.value)
        idealJob.put("text", text)
        idealJob.put("arrImages", arrImages)
        idealJob.put("audioUrl", audioUrl)
        idealJob.put("videoURL", videoURL)
        jobSeeker?.let { idealJob.put("jobSeeker", it) }
        return idealJob
    }


    init {
        this.text = obj.fetchIfNeeded<ParseObject>().getString("text") ?: ""
        this.arrImages = (obj["arrImages"] as? ArrayList<String>) ?: ArrayList()
        this.audioUrl = obj.getString("audioUrl") ?: ""
        this.videoURL = obj.getString("videoURL") ?: ""
        this.jobSeeker = obj.getParseObject("jobSeeker")
    }
}