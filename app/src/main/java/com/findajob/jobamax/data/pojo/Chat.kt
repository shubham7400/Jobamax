package com.findajob.jobamax.data.pojo

import com.parse.ParseClassName
import com.parse.ParseObject

@ParseClassName("Chat")
class Chat : ParseObject() {

    var message: String?
        get() = getString(MESSAGE)
        set(body) = put(MESSAGE, body!!)

    var senderId: ParseObject
        get() = getParseObject(SENDER_ID)!!
        set(senderId) = put(SENDER_ID, senderId)

    var receiverId: ParseObject
        get() = getParseObject(RECEIVER_ID)!!
        set(receiverId) = put(RECEIVER_ID, receiverId)

    var file: String
        get() = getString(FILE) ?: FILE
        set(file) = put(FILE, file)

    var seen: Boolean
        get() = getBoolean("seen")
        set(seen) = put("seen", seen)

    companion object {
        const val MESSAGE = "message"
        const val SENDER_ID = "senderId"
        const val RECEIVER_ID = "receiverId"
        const val FILE = "file"
    }
}

