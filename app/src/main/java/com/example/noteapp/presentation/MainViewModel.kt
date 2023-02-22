package com.example.noteapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.NoteRepositoryImpl
import com.example.noteapp.domain.DeleteNoteUseCase
import com.example.noteapp.domain.EditNoteUseCase
import com.example.noteapp.domain.GetNoteListUseCase
import com.example.noteapp.domain.NoteItem

class MainViewModel : ViewModel() {
    private val repositoryImpl = NoteRepositoryImpl

    private val deleteNoteUseCase = DeleteNoteUseCase(repositoryImpl)
    private val getNoteListUseCase = GetNoteListUseCase(repositoryImpl)
    private val editNoteUseCase = EditNoteUseCase(repositoryImpl)

    val noteList = getNoteListUseCase.getNoteList()

    fun deleteNote(noteItem: NoteItem) {
        deleteNoteUseCase.deleteNote(noteItem)
    }

    fun changeEnableState(noteItem: NoteItem) {
        val newNote = noteItem.copy(enabled = !noteItem.enabled)
        editNoteUseCase.editNote(newNote)
    }
}