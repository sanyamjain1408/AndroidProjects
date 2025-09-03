package com.example.a17_loginsignup

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a17_loginsignup.databinding.ActivityAllNotesBinding
import com.example.a17_loginsignup.databinding.DialogUpdateNoteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllNotes : AppCompatActivity(), NoteAdapter.OnItemClickListener {
    private val binding: ActivityAllNotesBinding by lazy {
        ActivityAllNotesBinding.inflate(layoutInflater)
    }
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()
        recyclerView = binding.notesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val currentUser = auth.currentUser
        currentUser?.let { user ->
            val noteReference = databaseReference.child("users").child(user.uid).child("notes")
            noteReference.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val noteList = mutableListOf<NoteItem>()
                    for (noteSnapshot in snapshot.children){
                        val note = noteSnapshot.getValue(NoteItem::class.java)
                        note?.let {
                            noteList.add(it)
                        }
                    }
                    noteList.reverse()
                    val adapter = NoteAdapter(noteList,this@AllNotes)
                    recyclerView.adapter = adapter
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        }

    }

    override fun onDeleteClick(noteId: String) {
        val currentUser = auth.currentUser
        currentUser?.let { user ->
            val noteReference = databaseReference.child("users").child(user.uid).child("notes")
                noteReference.child(noteId).removeValue()
        }
    }

    override fun onUpdateClick(noteId: String, currentTitle: String, currentDescription: String) {
        val dialogBinding = DialogUpdateNoteBinding.inflate(LayoutInflater.from(this))
        val dialog = AlertDialog.Builder(this).setView(dialogBinding.root).create()

            dialogBinding.updatenotetitle.setText(currentTitle)
        dialogBinding.updatenotedescription.setText(currentDescription)

        dialogBinding.savebutton.setOnClickListener {
            val newTitle= dialogBinding.updatenotetitle.text.toString()
            val newDescription = dialogBinding.updatenotedescription.text.toString()
            updateNoteDatabase(noteId, newTitle, newDescription)
            dialog.dismiss()
        }
        dialogBinding.cancelbutton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()




    }

    private fun updateNoteDatabase(noteId: String, newTitle: String, newDescription: String) {

        val currentUser = auth.currentUser
        currentUser?. let { user ->
            val noteReference = databaseReference.child("users").child(user.uid).child("notes")
            val updateNote = NoteItem(newTitle,newDescription,noteId)
            noteReference.child(noteId).setValue(updateNote)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Note Updated Successful", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Failed to Update Note", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}