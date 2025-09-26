package com.example.a16_advanceanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationView1 = findViewById<LottieAnimationView>(R.id.lottie_view1)
        animationView1.setAnimation("piggy.json") // assets folder se load karega
        animationView1.repeatCount = LottieDrawable.INFINITE
        animationView1.playAnimation()

        val animationView2 = findViewById<LottieAnimationView>(R.id.lottie_view2)
        animationView2.setAnimation("Login.json") // assets folder se load karega
        animationView2.repeatCount = LottieDrawable.INFINITE
        animationView2.playAnimation()

    }
}
