package com.example.a16_advanceanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationView = findViewById<LottieAnimationView>(R.id.lottie_view)
        animationView.setAnimation("piggy.json") // assets folder se load karega
        animationView.repeatCount = LottieDrawable.INFINITE
        animationView.playAnimation()

    }
}
