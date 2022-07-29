package com.tynkovski.android.profnotes.presentation.fragments.home.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class NoteDecorator(
    private val margin: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        parent.getChildAdapterPosition(view).also { pos ->
            if (pos != RecyclerView.NO_POSITION)
                outRect.bottom = margin
        }
    }
}