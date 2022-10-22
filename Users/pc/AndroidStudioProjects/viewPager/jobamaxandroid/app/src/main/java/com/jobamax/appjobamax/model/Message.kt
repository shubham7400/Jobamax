package com.jobamax.appjobamax.model

import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.parse.ParseObject

class Message {
    var messageParseObject: ParseObject? = null
    var senderId: String = ""
    var seenBy: List<String> = listOf()
    var mediaCaption: String = ""
    var messageId: String = ""
    var threadId: String = ""
    var mediaUrl: String = ""
    var text: String = ""
    var type: Int = -1

    fun toParseObject(): ParseObject {
        val message = ParseObject(ParseTableName.MESSAGE.value)

        message.put(ParseTableFields.SENDER_ID.value, senderId)
        message.put(ParseTableFields.SEEN_BY.value, seenBy)
        message.put(ParseTableFields.MEDIA_CAPTION.value, mediaCaption)
        message.put(ParseTableFields.MESSAGE_ID.value, messageId)
        message.put(ParseTableFields.THREAD_ID.value, threadId)
        message.put(ParseTableFields.MEDIA_URL.value, mediaUrl)
        message.put(ParseTableFields.TEXT.value, text)
        message.put(ParseTableFields.TYPE.value, type)

        return message
    }

    constructor(obj: ParseObject) {
        this.messageParseObject = obj
        this.senderId = obj[ParseTableFields.SENDER_ID.value]?.toString() ?: ""
        this.seenBy = (obj[ParseTableFields.SEEN_BY.value] as? List<String>) ?: listOf()
        this.mediaCaption = obj[ParseTableFields.MEDIA_CAPTION.value]?.toString() ?: ""
        this.messageId = obj[ParseTableFields.MESSAGE_ID.value]?.toString() ?: ""
        this.threadId = obj[ParseTableFields.THREAD_ID.value]?.toString() ?: ""
        this.mediaUrl = obj[ParseTableFields.MEDIA_URL.value]?.toString() ?: ""
        this.text = obj[ParseTableFields.TEXT.value]?.toString() ?: ""
        this.type = obj[ParseTableFields.TYPE.value]?.toString()?.toInt() ?: -1
     }

    constructor()
}