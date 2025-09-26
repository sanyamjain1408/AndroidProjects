package com.example.a17_loginsignup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a17_loginsignup.databinding.ActivityAddNoteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNoteActivity : AppCompatActivity() {
    private val binding: ActivityAddNoteBinding by lazy {
        ActivityAddNoteBinding.inflate(layoutInflater)
    }
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()

        binding.savenotes.setOnClickListener {

            //get text from title or description
            val title = binding.title.text.toString()
            val description = binding.description.text.toString()

            if (title.isEmpty() && description.isEmpty()) {
                Toast.makeText(this, "Fill both Field", Toast.LENGTH_SHORT).show()
            } else {
                val currentuser = auth.currentUser
                currentuser?.let { user ->
                    //Generate a unique key for the note
                    val noteKet = databaseReference.child("users").child(user.uid).child("notes").push().key

                    //note item instance

                    val noteItem = NoteItem(title,description,noteKet ?:"")
                    if (noteKet!=null)
                        //add notes to the user note
                        databaseReference.child("users").child(user.uid).child("notes").child(noteKet).setValue(noteItem)
                            .addOnCompleteListener{task ->
                                Toast.makeText(this, "Note save Successful", Toast.LENGTH_SHORT).show()
                                finish()
                            }else{
                        Toast.makeText(this, "Failed to save Note", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
}
