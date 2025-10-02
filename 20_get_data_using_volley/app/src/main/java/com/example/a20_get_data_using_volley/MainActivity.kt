package com.example.a20_get_data_using_volley

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    var url = "https://api.github.com/users"
    private var userinformationItem = arrayListOf<userinformationItem>()
    var userinformation = userinformation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stringRequest = StringRequest(url, Response.Listener {

            val gsonBuilder = GsonBuilder()
            val gson = gsonBuilder.create()
            val userArray = gson.fromJson(it, Array<userinformationItem>::class.java)

            userinformationItem.clear()
            userinformationItem.addAll(userArray.toList())

            userinformationItem.forEach { item ->
                userinformation.add(item)
            }
            Toast.makeText(this, userinformation.toString(), Toast.LENGTH_SHORT).show()

        }, Response.ErrorListener {
            Toast.makeText(this@MainActivity, "Something went wrong"+it.toString(), Toast.LENGTH_SHORT).show()

        })

        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)


    }
}