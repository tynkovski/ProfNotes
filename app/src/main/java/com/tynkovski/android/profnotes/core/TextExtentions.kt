package com.tynkovski.android.profnotes.core

import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import androidx.core.text.toSpannable

fun CharSequence.findSubstringIndexes(substring: String) = substring.toRegex(emptySet())
    .findAll(this ?: "")
    .map { it.range.first to it.range.last }
    .toList()

fun CharSequence.colorString(startIndex: Int, endIndex: Int, color: Int) = toSpannable().apply {
    setSpan(
        ForegroundColorSpan(color), startIndex, endIndex + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}

fun CharSequence.colorSubString(substring: String, color: Int) = toSpannable().apply {
    findSubstringIndexes(substring).forEach {
        colorString(it.first, it.second, color)
    }
}

fun CharSequence.underlineString() = toSpannable().apply {
    setSpan(
        UnderlineSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}