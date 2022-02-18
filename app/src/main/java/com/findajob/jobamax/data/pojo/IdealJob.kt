package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.enums.ParseTableName
import com.parse.ParseObject

class IdealJob {
    var text: String = ""
    var arrImages = ArrayList<String>()
    var audioUrl: String = ""
    var videoUrl: String = ""
    var jobSeeker: ParseObject? = null
    var pfObject: ParseObject? = null

    fun toParseObject(): ParseObject {
        val portfolio = ParseObject(ParseTableName.Portfolio.toString())
        portfolio.put("text", text)
        portfolio.put("arrImages", arrImages)
        portfolio.put("audioUrl", audioUrl)
        portfolio.put("videoUrl", videoUrl)
        jobSeeker?.let { portfolio.put("jobSeeker", it) }
        return portfolio
    }


    constructor(obj: ParseObject) {
        this.text = obj.getString("text").toString()
        this.arrImages = (obj["arrImages"] as? ArrayList<String>) ?: ArrayList()
        this.audioUrl = obj.getString("audioUrl") ?: ""
        this.videoUrl = obj.getString("videoUrl")?: ""
        this.jobSeeker = obj.getParseObject("jobSeeker")
        this.pfObject = obj
    }
}