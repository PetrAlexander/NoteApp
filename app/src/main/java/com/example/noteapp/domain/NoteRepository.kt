package com.example.noteapp.domain

interface NoteRepository {
    fun addNote(noteItem: NoteItem)
    fun deleteNote(noteItem: NoteItem)
    fun editNote(noteItem: NoteItem)
    fun getNoteList(): List<NoteItem>
    fun getNote(noteId: Int): NoteItem
}