package com.example.noteapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noteapp.domain.NoteItem
import com.example.noteapp.domain.NoteRepository

object NoteRepositoryImpl : NoteRepository {

    private val noteListLiveData = MutableLiveData<List<NoteItem>>()
    private val noteList = mutableListOf<NoteItem>()
    private var idAutoIncrement = 0

    override fun addNote(noteItem: NoteItem) {
        if (noteItem.id == NoteItem.UNDEFINED_ID) {
            noteItem.id = idAutoIncrement++
        }
        noteList.add(noteItem)
        updateNoteList()
    }

    override fun deleteNote(noteItem: NoteItem) {
        noteList.remove(noteItem)
        updateNoteList()
    }

    override fun editNote(noteItem: NoteItem) {
        val oldNote = getNote(noteItem.id)
        noteList.remove(oldNote)
        addNote(noteItem)
    }

    override fun getNoteList(): LiveData<List<NoteItem>> {
        return noteListLiveData
    }

    override fun getNote(noteId: Int): NoteItem {
        return noteList.find { it.id == noteId }
            ?: throw RuntimeException("Can't find note with $noteId id")
    }

    private fun updateNoteList() {
        noteListLiveData.value = noteList.toList()
    }
}