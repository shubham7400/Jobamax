package com.jobamax.appjobamax.model

import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.parse.ParseObject
import java.io.Serializable

class ChatThread : Serializable {
    @Transient
    var chatThreadParseObject: ParseObject? = null
    @Transient
    var jobSeekerParseObject: ParseObject? = null
    @Transient
    var recruiterParseObject: ParseObject? = null
    var threadId: String = ""
    var deleteHistory: List<String> = listOf()
    var deletedBy: List<String> = listOf()
    var latestText: String = ""
    var archivedBy: List<String> = listOf()
    var jobTitle: String = ""
    var jobSeekerId: String = ""
    var jsFilter: Int = -1
    var jobOfferId: String = ""


    fun toParseObject(): ParseObject {
        val chatThread = ParseObject(ParseTableName.CHAT_THREAD.value)

        jobSeekerParseObject?.let { chatThread.put(ParseTableFields.JOB_SEEKER.value, it) }
        recruiterParseObject?.let { chatThread.put(ParseTableFields.RECRUITER.value, it) }
        chatThread.put(ParseTableFields.THREAD_ID.value, threadId)
        chatThread.put(ParseTableFields.DELETE_HISTORY.value, deleteHistory)
        chatThread.put(ParseTableFields.DELETED_BY.value, deletedBy)
        chatThread.put(ParseTableFields.LATEST_TEXT.value, latestText)
        chatThread.put(ParseTableFields.ARCHIVED_BY.value, archivedBy)
        chatThread.put(ParseTableFields.JOB_TITLE.value, jobTitle)
        chatThread.put(ParseTableFields.JOB_SEEKER_ID.value, jobSeekerId)
        chatThread.put(ParseTableFields.JS_Filter.value, jsFilter)
        chatThread.put(ParseTableFields.JOB_OFFER_ID.value, jobOfferId)

        return chatThread
    }


    constructor(obj: ParseObject) {
        this.chatThreadParseObject = obj
        this.jobSeekerParseObject = obj.getParseObject(ParseTableFields.JOB_SEEKER.value)
        this.recruiterParseObject = obj.getParseObject(ParseTableFields.RECRUITER.value)
        this.threadId = obj[ParseTableFields.THREAD_ID.value]?.toString() ?: ""
        this.deleteHistory = (obj[ParseTableFields.DELETE_HISTORY.value] as? List<String>) ?: listOf()
        this.deletedBy = (obj[ParseTableFields.DELETED_BY.value] as? List<String>) ?: listOf()
        this.latestText = obj[ParseTableFields.LATEST_TEXT.value]?.toString() ?: ""
        this.archivedBy = (obj[ParseTableFields.ARCHIVED_BY.value] as? List<String>) ?: listOf()
        this.jobTitle = obj[ParseTableFields.JOB_TITLE.value]?.toString() ?: ""
        this.jobSeekerId = obj[ParseTableFields.JOB_SEEKER_ID.value]?.toString() ?: ""
        this.jsFilter = obj[ParseTableFields.JS_Filter.value]?.toString()?.toInt() ?: -1
        this.jobOfferId = obj[ParseTableFields.JOB_OFFER_ID.value]?.toString() ?: ""
    }

    constructor()
}