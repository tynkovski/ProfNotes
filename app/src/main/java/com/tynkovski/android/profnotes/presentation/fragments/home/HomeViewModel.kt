package com.tynkovski.android.profnotes.presentation.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tynkovski.android.profnotes.R
import java.text.DateFormatSymbols
import java.util.Calendar
import java.util.Locale

class HomeViewModel : ViewModel() {
    private val _profileName = MutableLiveData<String>().apply {
        value = "Тестовый человек"
    }

    val profileName: LiveData<String> get() = _profileName

    fun getCurrentDayInfo(): String {
        val now = Calendar.getInstance()
        val format = DateFormatSymbols.getInstance()

        val day = now[Calendar.DAY_OF_MONTH]
        val dayOfWeek = format.weekdays[Calendar.getInstance()[Calendar.DAY_OF_WEEK]].replaceFirstChar {
            if (it.isLowerCase()) it.titlecase( Locale.getDefault()) else it.toString()
        }
        val month = format.months[Calendar.getInstance()[Calendar.MONTH]]

        return "$dayOfWeek, $day $month"
    }

    fun getNews(): String {
        return "4 новые заметки"
    }

    fun getCurrentDayStage(): Int {
        return when (Calendar.getInstance()[Calendar.HOUR_OF_DAY]) {
            in 7..12 -> R.string.morning_greetings
            in 13..18 -> R.string.day_greetings
            in 19..24 -> R.string.morning_greetings
            else -> R.string.night_greetings
        }
    }
}