package com.findajob.jobamax.extensions

import java.util.*

fun generateRandomAlphaNumeric(limit: Int): String {
    val charData = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    val sb = StringBuilder(limit)
    for (i in 0 until limit) {
        sb.append(charData[Random().nextInt(charData.length)])
    }
    return sb.toString()
}

fun String?.toTitleCase(): String {
    if (this == null) {
        return ""
    }

    val titleCase: StringBuilder = StringBuilder(this.length)
    var nextTitleCase = true

    val charArray = lowercase(Locale.getDefault()).toCharArray()

    for (i in charArray.indices) {
        if (!Character.isLetterOrDigit(charArray[i])) {
            nextTitleCase = true
        } else if (nextTitleCase) {
            charArray[i] = Character.toTitleCase(charArray[i])
            nextTitleCase = false
        }
        titleCase.append(charArray[i])
    }

    return titleCase.toString()
}