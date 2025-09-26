package com.example.share_bundlebundle_passing

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val name = findViewById<TextView>(R.id.showname)
        val fathername = findViewById<TextView>(R.id.showfname)
        val rollnumber = findViewById<TextView>(R.id.showrollnumber)
        val phonenumber = findViewById<TextView>(R.id.showphonenumber)

        val intent = intent
        val  names = intent.getStringExtra("name")
        val  fathersname = intent.getStringExtra("fathername")
        val  rollsnumber = intent.getStringExtra("rollnumber")
        val  phonesnumber = intent.getStringExtra("phonenumber")

        name.text = "Name : $names"
        fathername.text = "Father Name  : $fathersname"
        rollnumber.text = "Roll Number : $rollsnumber"
        phonenumber.text = "Phone Number : $phonesnumber"


    }
}