package com.example.customtoast

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.shashank.sony.fancytoastlib.FancyToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val defaultbutton = findViewById<Button>(R.id.Defaultbutton)
        val fancybutton = findViewById<Button>(R.id.fancybutton)
        val confusingbutton = findViewById<Button>(R.id.confusingbutton)
        val infobutton = findViewById<Button>(R.id.infobutton)
        val warningbutton = findViewById<Button>(R.id.warningbutton)

        defaultbutton.setOnClickListener {
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true).show();
        }
        fancybutton.setOnClickListener {
            FancyToast.makeText(this, "Hello jii 😊😊", FancyToast.LENGTH_LONG, FancyToast.SUCCESS,true).show();
        }
        confusingbutton.setOnClickListener {
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
        }
        infobutton.setOnClickListener {
            FancyToast.makeText(this,"Hello jii", FancyToast.LENGTH_LONG, FancyToast.INFO,true).show()
        }
        warningbutton.setOnClickListener {
            FancyToast.makeText(this,"Hello jii", FancyToast.LENGTH_LONG, FancyToast.WARNING,true).show()
        }

    }
}