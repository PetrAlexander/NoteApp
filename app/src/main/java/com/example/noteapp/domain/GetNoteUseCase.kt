package com.example.noteapp.domain

class GetNoteUseCase(private val noteRepository: NoteRepository) {

    fun getNote(noteId: Int): NoteItem {
        return noteRepository.getNote(noteId)
    }
}