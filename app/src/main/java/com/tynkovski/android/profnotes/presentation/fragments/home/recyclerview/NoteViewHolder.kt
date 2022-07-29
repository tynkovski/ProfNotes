package com.tynkovski.android.profnotes.presentation.fragments.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.data.model.NoteEntity
import com.tynkovski.android.profnotes.data.model.NoteEntity.NoteType
import com.tynkovski.android.profnotes.databinding.ItemNoteBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class NoteViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
) {
    private val binding by viewBinding(ItemNoteBinding::bind)

    fun bind(note: NoteEntity) {
        with(binding) {
            val colorAccent = when (note.type) {
                NoteType.InProgress -> {
                    val now = Calendar.getInstance()
                    val date = Calendar.Builder().setInstant(note.timeOfCreation).build()

                    val differenceInMillis = 300000L
                    if (now.timeInMillis - date.timeInMillis < differenceInMillis)
                        R.color.blue
                    else
                        R.color.green
                }
                NoteType.Delayed -> R.color.yellow
                NoteType.Completed -> R.color.red
            }

            tvType.apply {
                hashMapOf(
                    R.color.red to R.string.completed_note,
                    R.color.yellow to R.string.delayed_note,
                    R.color.blue to R.string.new_note,
                    R.color.green to R.string.in_progress_note,
                ).also {
                    text = resources.getString(it[colorAccent] ?: R.color.white)
                }
                setTextColor(resources.getColor(colorAccent, null))
            }

            materialDividerVertical.apply {
                dividerColor = resources.getColor(colorAccent, null)
            }

            tvTitleNote.apply {
                text = note.title
            }

            tvDescriptionNote.apply {
                text = note.description
            }

            tvChangeStatus.apply {
                // Тут будет ClickListener
            }

            tvTime.apply {
                Calendar.Builder().setInstant(note.timeToComplete).build().also { timeToComplete ->
                    text = SimpleDateFormat("HH:mm").format(timeToComplete.time)
                }
            }
        }
    }
}