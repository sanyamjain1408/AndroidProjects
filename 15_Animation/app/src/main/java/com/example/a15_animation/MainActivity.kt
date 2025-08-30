package com.example.a15_animation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.animation.AnimationUtils


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animText = findViewById<TextView>(R.id.textView)
        val fadein = findViewById<TextView>(R.id.fadein)
        val fadeout = findViewById<TextView>(R.id.fadeout)
        val zoomin = findViewById<TextView>(R.id.zoomin)
        val zoomout = findViewById<TextView>(R.id.zoomout)
        val slideup = findViewById<TextView>(R.id.slideup)
        val slidedown = findViewById<TextView>(R.id.slidedown)
        val bounce= findViewById<TextView>(R.id.bounce)
        val rotate = findViewById<TextView>(R.id.rotate)

        fadein.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.fade_in)
            animText.startAnimation(animationFadeIn)
        }
        fadeout.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.fade_out)
            animText.startAnimation(animationFadeIn)
        }
        zoomin.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.zoom_in)
            animText.startAnimation(animationFadeIn)
        }
        zoomout.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.zoom_out)
            animText.startAnimation(animationFadeIn)
        }
        slideup.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.slide_up)
            animText.startAnimation(animationFadeIn)
        }
        slidedown.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.slide_down)
            animText.startAnimation(animationFadeIn)
        }
        bounce.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.bounce)
            animText.startAnimation(animationFadeIn)
        }
        rotate.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this ,R.anim.rotate)
            animText.startAnimation(animationFadeIn)
        }
    }
}