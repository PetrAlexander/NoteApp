package com.example.noteapp.domain

data class NoteItem(
    val id: Int,
    val name: String,
    val priority: Int,
    val enabled: Boolean
)
