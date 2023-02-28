package com.example.noteapp.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R

class NoteItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.textViewNoteText)
    val tvPriority = view.findViewById<TextView>(R.id.textViewPriority)
}