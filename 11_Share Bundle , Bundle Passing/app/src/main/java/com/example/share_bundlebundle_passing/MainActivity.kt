package com.example.share_bundlebundle_passing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val fathername = findViewById<EditText>(R.id.fname)
        val rollnumber = findViewById<EditText>(R.id.rollnumber)
        val phonenumber = findViewById<EditText>(R.id.phonenumber)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = name.text.toString()
            val fathername = fathername.text.toString()
            val rollnumber = rollnumber.text.toString()
            val phonenumber = phonenumber.text.toString()

            val intent= Intent(this, ProfileActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("fathername",fathername)
            intent.putExtra("rollnumber",rollnumber)
            intent.putExtra("phonenumber",phonenumber)
            startActivity(intent)

        }

    }
}