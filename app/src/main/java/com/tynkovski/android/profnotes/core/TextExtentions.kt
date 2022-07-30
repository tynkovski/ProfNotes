package com.tynkovski.android.profnotes.core

import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import androidx.core.text.toSpannable

fun CharSequence.colorString(startIndex: Int, endIndex: Int, color: Int): Spannable {
    val spannable = this.toSpannable()
    spannable.setSpan(
        ForegroundColorSpan(color),
        startIndex,
        endIndex,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return spannable
}

fun CharSequence.colorString(color: Int): Spannable {
    val spannable = this.toSpannable()
    spannable.setSpan(
        ForegroundColorSpan(color), 0, this.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return spannable
}

fun CharSequence.underlineString(): Spannable {
    val spannable = this.toSpannable()
    spannable.setSpan(
        UnderlineSpan(),
        0,
        length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return spannable
}