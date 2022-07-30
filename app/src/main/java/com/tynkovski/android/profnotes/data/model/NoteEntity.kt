package com.tynkovski.android.profnotes.data.model

/*
 На будущее
 import android.os.Parcelable
 import kotlinx.parcelize.Parcelize
*/

data class NoteEntity(
    val id: Int,
    var title: String,
    var description: String,
    var type: NoteType,
    var timeToComplete: Long,
    var timeOfCreation: Long,
    var replayFlag: Int // Флаг повторов по дням недели: 0 - без повторов, 127 - повтор каждый день (0b1111111)
) {
    enum class NoteType {
        InProgress, Delayed, Completed
    }
}