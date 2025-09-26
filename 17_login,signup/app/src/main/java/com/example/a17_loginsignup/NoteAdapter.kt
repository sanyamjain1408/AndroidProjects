package com.example.a17_loginsignup

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.a17_loginsignup.databinding.NotesitemBinding



class NoteAdapter(private val notes : List<NoteItem>, private val itemClickListener: OnItemClickListener):
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
        interface OnItemClickListener{
            fun onDeleteClick(noteId: String)
            fun onUpdateClick(noteId: String , title: String, description: String)
        }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        val binding : NotesitemBinding = NotesitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {
        val note = notes[position]
        holder.bind(note)
        holder.binding.update.setOnClickListener {
            itemClickListener.onUpdateClick(note.noteId, note.title, note.description)
        }
        holder.binding.delete.setOnClickListener {
            itemClickListener.onDeleteClick(note.noteId)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class NoteViewHolder(val binding: NotesitemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(note : NoteItem){

            binding.titleTextView.text = note.title
            binding.descriptionTextView.text = note.description
        }

    }
}


