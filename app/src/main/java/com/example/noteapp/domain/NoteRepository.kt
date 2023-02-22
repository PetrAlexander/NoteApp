package com.example.noteapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface NoteRepository {
    fun addNote(noteItem: NoteItem)
    fun deleteNote(noteItem: NoteItem)
    fun editNote(noteItem: NoteItem)
    fun getNoteList(): LiveData<List<NoteItem>>
    fun getNote(noteId: Int): NoteItem
}