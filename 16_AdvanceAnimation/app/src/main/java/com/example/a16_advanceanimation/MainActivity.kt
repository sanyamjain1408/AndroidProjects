package com.example.a16_advanceanimation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lottiefiles.dotlottie.core.widget.DotLottieAnimation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dotLottieAnimationView = findViewById<DotLottieAnimation>(R.id.lottie_view)
    }
}