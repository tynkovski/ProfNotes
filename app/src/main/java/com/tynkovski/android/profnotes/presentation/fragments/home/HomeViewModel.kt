package com.tynkovski.android.profnotes.presentation.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.data.model.NoteEntity
import com.tynkovski.android.profnotes.data.model.NoteEntity.NoteType
import java.text.DateFormatSymbols
import java.util.Calendar
import java.util.Locale

class HomeViewModel : ViewModel() {
    private val _profileName = MutableLiveData<String>().apply {
        value = "Тестовый человек"
    }
    private val _notes = MutableLiveData<ArrayList<NoteEntity>>().apply {
        value = arrayListOf(
            NoteEntity(
                0, "Школа разработки", "Сделать приложение",
                NoteType.InProgress, 43200000L, 1659119481496L, 0
            ),
            NoteEntity(
                1, "Андроид", "Изучение андроида",
                NoteType.InProgress, 43300000L, 1659119481496L, 127
            ),
            NoteEntity(
                2, "Изучение побочного материала", "Изучать чето там",
                NoteType.Delayed, 43400000L, 1659119481496L, 7
            ),
            NoteEntity(
                3, "Выполнение ДЗ к понедельнику", "Сделать домашнее задание для профсофта",
                NoteType.Completed, 43400000L, 1659119481496L, 1
            ),
        )
    }

    val profileName: LiveData<String> get() = _profileName
    val notes: LiveData<ArrayList<NoteEntity>> get() = _notes

    fun getCurrentDayInfo(): String {
        val now = Calendar.getInstance()
        val format = DateFormatSymbols.getInstance()

        val day = now[Calendar.DAY_OF_MONTH]
        val dayOfWeek = format.weekdays[Calendar.getInstance()[Calendar.DAY_OF_WEEK]].replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
        }
        val month = format.months[now[Calendar.MONTH]]

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