package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.enums.ParseTableName
 import com.parse.ParseObject
 import kotlin.collections.ArrayList

class Portfolio(obj: ParseObject) {
    var text: String = ""
    var arrImages = ArrayList<String>()
    var links = ArrayList<String>()
    var audioUrl: String = ""
    var videoURL: String = ""
    var pfObject: ParseObject? = obj

    fun toParseObject(): ParseObject {
        val portfolio = ParseObject(ParseTableName.Portfolio.toString())
        portfolio.put("text", text)
        portfolio.put("arrImages", arrImages)
        portfolio.put("links", links)
        portfolio.put("audioUrl", audioUrl)
        portfolio.put("videoURL", videoURL)
        return portfolio
    }


    init {
        this.text = obj.fetchIfNeeded<ParseObject>().getString("text") ?: ""
        this.arrImages = (obj["arrImages"] as? ArrayList<String>) ?: ArrayList()
        this.links = (obj["links"] as? ArrayList<String>) ?: ArrayList()
        this.audioUrl = obj.getString("audioUrl") ?: ""
        this.videoURL = obj.getString("videoURL")?: ""
    }
}