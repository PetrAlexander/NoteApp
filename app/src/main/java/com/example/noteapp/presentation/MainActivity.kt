package com.example.noteapp.presentation

import android.net.wifi.aware.AttachCallback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.ThemedSpinnerAdapter.Helper
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var notesAdapter: NoteListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerView()
        viewModel.noteList.observe(this) {
            notesAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        notesAdapter = NoteListAdapter()
        recyclerView = findViewById(R.id.recyclerViewNotes)
        with(recyclerView) {
            adapter = notesAdapter
            recycledViewPool.setMaxRecycledViews(
                NoteListAdapter.VIEW_TYPE_ENABLED,
                NoteListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                NoteListAdapter.VIEW_TYPE_DISABLED,
                NoteListAdapter.MAX_POOL_SIZE
            )
        }
        setupOnLongClickListener()
        setupOnClickListener()
        setupOnSwipeClickListener()
    }

    private fun setupOnSwipeClickListener() {
        val callback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val noteItem = notesAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteNote(noteItem)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setupOnClickListener() {
        notesAdapter.onNoteItemClickListener = {
            Log.d("MAIN", it.name)
        }
    }

    private fun setupOnLongClickListener() {
        notesAdapter.onNoteItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
    }
}