package com.example.noteapp.domain

data class NoteItem(
    val name: String,
    val priority: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
