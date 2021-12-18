package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.model.User
import com.findajob.jobamax.util.ARG_CHAT_REQUIREMENTS
import com.parse.ParseClassName
import com.parse.ParseObject

//data class Messages (
//    val avatar: Int,
//    val name: String,
//    val message: String
//) {
//    companion object {
//        fun generateMockMessages(): List <Messages> {
//            return listOf(
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_01,
//                    name = "002",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_02,
//                    name = "003",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_03,
//                    name = "004",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_04,
//                    name = "005",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_05,
//                    name = "006",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_06,
//                    name = "007",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_07,
//                    name = "008",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_08,
//                    name = "009",
//                    message = "Lorem ipsum"
//                ),
//                Messages(
//                    avatar = R.drawable.img_avatar_dummy_09,
//                    name = "010",
//                    message = "Lorem ipsum"
//                ),
//            )
//        }
//    }
//}

@ParseClassName("Message")
class Message : ParseObject() {

//    var message: String
//        get() = getString(MESSAGE) ?: MESSAGE
//        set(Chat) = put(MESSAGE, Chat)

    var message: ParseObject?
        get() = getParseObject(MESSAGE) as? Chat ?: Chat()
        set(Chat) = put(MESSAGE, Chat!!)

    var senderId: ParseObject
        get() = getParseObject(SENDER_ID)!!
        set(senderId) = put(SENDER_ID, senderId)

    var receiverId: ParseObject
        get() = getParseObject(RECEIVER_ID) ?: createWithoutData(User.CLASS_NAME, "0")
        set(receiverId) = put(RECEIVER_ID, receiverId)

    var file: ParseObject?
        get() = getParseObject(FILE) as? Chat ?: Chat()
        set(Chat) = put(FILE, Chat!!)

    var shortListedBy: List<String>
        get() = getList(SHORT_LISTED_BY) ?: listOf<String>()
        set(list) = put(SHORT_LISTED_BY, list)

    var seenBy: List<String>
        get() = getList("seenBy") ?: emptyList()
        set(seenBy) = put("seenBy", seenBy)

    var isJob: Boolean
        get() = getBoolean(IS_JOB) ?: false
        set(isReach) = put(IS_JOB, isReach)

    var isNetworking: Boolean
        get() = getBoolean(IS_NETWORKING) ?: false
        set(isNetworking) = put(IS_NETWORKING, isNetworking)

    var isSource: Boolean
        get() = getBoolean(IS_SOURCE)
        set(isSource) = put(IS_SOURCE, isSource)

    var isArchived: Boolean
        get() = getBoolean(IS_ARCHIVED) ?: false
        set(isArchived) = put(IS_ARCHIVED, isArchived)

    var requirements: List<String>
        get() = getList(ARG_CHAT_REQUIREMENTS) ?: emptyList()
        set(list) = put(ARG_CHAT_REQUIREMENTS, list)

    companion object {
        const val MESSAGE = "message"
        const val IS_JOB = "isJob"
        const val IS_NETWORKING = "isNetworking"
        const val IS_ARCHIVED = "isArchived"
        const val SENDER_ID = "senderId"
        const val RECEIVER_ID = "receiverId"
        const val FILE = "file"
        const val SHORT_LISTED_BY = "shortListedBy"
        const val IS_SOURCE = "isSource"
    }
}
