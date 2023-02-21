package com.example.noteapp.domain

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {

    fun deleteNote(noteItem: NoteItem) {
        noteRepository.deleteNote(noteItem)
    }
}