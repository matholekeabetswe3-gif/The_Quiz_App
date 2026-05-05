package com.example.thequizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val ivGif: ImageView = findViewById(R.id.ivSplashGif)

        // Load your GIF
        Glide.with(this)
                .load(R.drawable.animation_splash) // Changed from splash_gif to existing drawable to fix build
                .into(ivGif)

        // Wait 3 seconds then go to MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Close splash so user can't go back to it
        }, 3000) // 3000ms = 3 seconds
    }
}
