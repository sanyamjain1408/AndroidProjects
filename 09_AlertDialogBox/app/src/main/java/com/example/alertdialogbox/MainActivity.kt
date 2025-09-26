 package com.example.alertdialogbox

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val  dialog = AlertDialog.Builder(this)

            dialog.setTitle("Delete Files")
            dialog.setMessage("Do you want to delete file")
            dialog.setIcon(R.drawable.delete_icon)

            dialog.setPositiveButton("Yes"){dialogInterface, which ->
                Toast.makeText(this, "Clicked Yes", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(this, "Clicked No", Toast.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("Cancel"){dialogInterface, which ->
                Toast.makeText(this, "Clicked Cancel", Toast.LENGTH_SHORT).show()
            }

            val alertDialog: AlertDialog = dialog.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }
}