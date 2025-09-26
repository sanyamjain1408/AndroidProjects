package com.example.a17_loginsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a17_loginsignup.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.logout.setOnClickListener {
            auth.signOut()   //Firebase Logout
            Toast.makeText(this, "Log-Out", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }

        binding.createnotesbutton.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }

        binding.opennotesbutton.setOnClickListener {
            startActivity(Intent(this, AllNotes::class.java))
        }

    }
}