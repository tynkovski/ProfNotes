package com.tynkovski.android.profnotes.presentation.fragments.home.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tynkovski.android.profnotes.data.model.NoteEntity

class NoteAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val notes = mutableListOf<NoteEntity>()

    override fun getItemCount() = notes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NoteViewHolder).bind(notes[position])
    }

    fun setItems(items: List<NoteEntity>) {
        this.notes.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}