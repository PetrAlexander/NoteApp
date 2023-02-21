package com.example.noteapp.domain

class GetNoteListUseCase(private val noteRepository: NoteRepository) {

    fun getNoteList(): List<NoteItem> {
        return noteRepository.getNoteList()
    }
}
