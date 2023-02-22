package com.example.noteapp.domain

import androidx.lifecycle.LiveData

class GetNoteListUseCase(private val noteRepository: NoteRepository) {

    fun getNoteList(): LiveData<List<NoteItem>> {
        return noteRepository.getNoteList()
    }
}
