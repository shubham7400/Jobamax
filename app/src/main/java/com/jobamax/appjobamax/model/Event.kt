package com.jobamax.appjobamax.model

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.*

@ParseClassName(Event.CLASS_NAME)
class Event : ParseObject() {

    var name: String
        set(name) = put(NAME, name)
        get() = getString(NAME) ?: ""

    var organiser: ParseObject?
        set(organiser) = put(ORGANISER, organiser as ParseObject)
        get() = getParseObject(ORGANISER)

    var date: Date
        set(date) = put(DATE, date)
        get() = getDate(DATE) ?: Date()

    var day: String
        set(day) = put(DAY, day)
        get() = getString(DAY) ?: ""

    var interest: ParseObject?
        set(interest) = put(INTEREST, interest as ParseObject)
        get() = getParseObject(INTEREST)

    companion object {
        const val CLASS_NAME = "EventDemo"
        const val ID = "id"
        const val INTEREST = "Interests"
        const val NAME = "name"
        const val ORGANISER = "organiser"
        const val DATE = "date"
        const val DAY = "day"
    }

    override fun toString() = "" +
            "\n===EVENT $name ===\n" +
            "$ID -> $objectId\n" +
            "$NAME -> $name\n" +
            "$DATE -> ${date.toLocaleString()}\n" +
            "$DAY -> $day\n" +
            "$ORGANISER -> $organiser\n" +
            ""
}

