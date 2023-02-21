package com.example.noteapp.domain

class EditNoteUseCase(private val noteRepository: NoteRepository) {

    fun editNote(noteItem: NoteItem) {
        noteRepository.editNote(noteItem)
    }
}