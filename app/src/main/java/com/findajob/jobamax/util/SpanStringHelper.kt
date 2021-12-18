package com.findajob.jobamax.util

import android.content.Context
import android.content.res.Resources.getSystem
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat


fun SpannableString.setColor(context: Context, target: String, @ColorRes color: Int) {
    val start = indexOf(target)
    val end = target.length + start
    setSpan(
        ForegroundColorSpan(
            ContextCompat.getColor(
                context,
                color
            )
        ), start, end, 0
    )
}

fun SpannableString.setTypeFace(style: Int, target: String) {
    val start = indexOf(target)
    val end = target.length + start
    setSpan(StyleSpan(style), start, end, 0)
}

fun SpannableString.setSize(sizeDp: Int, target: String) {
    val start = indexOf(target)
    val end = target.length + start
    setSpan(AbsoluteSizeSpan(sizeDp.px), start, end, 0)
}

fun SpannableString.strikeThrough(target: String) {
    val start = indexOf(target)
    val end = target.length + start
    setSpan(StrikethroughSpan(), start, end, 0)
}

val Int.px: Int get() = (this * getSystem().displayMetrics.density).toInt()
