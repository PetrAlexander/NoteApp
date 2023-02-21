package com.example.noteapp.domain

class AddNoteUseCase(private val noteRepository: NoteRepository) {

    fun addNote(noteItem: NoteItem) {
        noteRepository.addNote(noteItem)
    }
}