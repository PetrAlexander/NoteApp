package com.example.noteapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.domain.NoteItem

class NoteListAdapter : ListAdapter<NoteItem, NoteItemViewHolder>(NoteItemDiffCallback()) {
    var onNoteItemLongClickListener: ((NoteItem) -> Unit)? = null
    var onNoteItemClickListener: ((NoteItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_note_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_note_disabled
            else -> throw Exception("Unknown viewType: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return NoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val noteItem = getItem(position)
        holder.tvName.text = noteItem.name
        holder.tvPriority.text = noteItem.priority.toString()
        holder.view.setOnLongClickListener {
            onNoteItemLongClickListener?.invoke(noteItem)
            true
        }
        holder.view.setOnClickListener {
            onNoteItemClickListener?.invoke(noteItem)
        }
    }


    override fun getItemViewType(position: Int): Int {
        val noteItem = getItem(position)
        return if (noteItem.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
        const val MAX_POOL_SIZE = 15
    }
}