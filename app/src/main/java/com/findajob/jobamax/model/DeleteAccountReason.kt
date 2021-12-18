package com.findajob.jobamax.model

import com.parse.ParseObject

class DeleteAccountReason(
    val reason: String,
    private val accountId: String
) {

    fun toParseObject(): ParseObject {
        val parseObject = ParseObject("DeleteAccountReason")
        parseObject.put("reason", reason)
        parseObject.put("accountId", accountId)
        return parseObject
    }

}