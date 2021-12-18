package com.findajob.jobamax.util

import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*


fun Date.month(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.MONTH) + 1
}


fun Date.afterDays(day: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, +day)
    return calendar.time
}

fun Date.date(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.DATE) + 1
}

fun Date.year(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.YEAR)
}


fun Date.addYear(n: Int): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    cal.add(Calendar.YEAR, n)
    return cal.time
}


fun Date.dd_MM_yy(): String {
    val format = SimpleDateFormat("dd/MM/yy", Locale.US)
    return format.format(this)
}

fun Date.yyyyMMddHHmmss(): String {
    val format = SimpleDateFormat("yyyyMMddHHmmss", Locale.US)
    return format.format(this)
}

fun Date.yyyyMMdd(): String {
    val format = SimpleDateFormat("yyyyMMdd", Locale.US)
    return format.format(this)
}

fun Date.toText(): String {
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    return format.format(this)
}

fun Date.mm_yy(): String {
    val format = SimpleDateFormat("MM-yy", Locale.US)
    return format.format(this)
}

fun Date.mm_yy_disp(): String {
    val format = SimpleDateFormat("MM/yy", Locale.US)
    return format.format(this)
}

fun String.parseDisplayMonthFormat(): String {
    val originalFormat = SimpleDateFormat("MM-yy", Locale.US)
    val displayFormat = SimpleDateFormat("MM/yy", Locale.US)
    try {
        originalFormat.parse(this)?.let {
            return displayFormat.format(it)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return ""
}


fun DatePicker.retrieveDate(): Date {
    val day = dayOfMonth
    val month = month
    val year = year
    val calendar: Calendar = Calendar.getInstance()
    calendar.set(year, month, day)
    return calendar.time
}

fun Date.startOfDay(): Date {
    val date = this
    date.hours = 0
    date.minutes = 0
    date.seconds = 0
    return date
}

fun String.parseMonthFormat(): String {
    val originalFormat = SimpleDateFormat("MM/yy", Locale.US)
    val displayFormat = SimpleDateFormat("MM-yy", Locale.US)
    try {
        originalFormat.parse(this)?.let {
            return displayFormat.format(it)
        }
    } catch (e: Exception) {

    }
    return ""
}