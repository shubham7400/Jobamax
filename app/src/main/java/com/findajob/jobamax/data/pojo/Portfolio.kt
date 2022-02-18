package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.enums.ParseTableName
 import com.parse.ParseObject
 import kotlin.collections.ArrayList

class Portfolio {
    var text: String = ""
    var arrImages = ArrayList<String>()
    var audioUrl: String = ""
    var videoUrl: String = ""
    var pfObject: ParseObject? = null

    fun toParseObject(): ParseObject {
        val portfolio = ParseObject(ParseTableName.Portfolio.toString())
        portfolio.put("text", text)
        portfolio.put("arrImages", arrImages)
        portfolio.put("audioUrl", audioUrl)
        portfolio.put("videoUrl", videoUrl)
        return portfolio
    }


    constructor(obj: ParseObject) {
        this.text = obj.getString("text").toString()
        this.arrImages = (obj["arrImages"] as? ArrayList<String>) ?: ArrayList()
        this.audioUrl = obj.getString("audioUrl") ?: ""
        this.videoUrl = obj.getString("videoUrl")?: ""
        this.pfObject = obj
    }
}