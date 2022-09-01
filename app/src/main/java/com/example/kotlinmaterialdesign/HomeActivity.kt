package com.example.kotlinmaterialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun joinButton(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        this.overridePendingTransition(
            R.anim.animation_enter, R.anim.anim_slide_out_left
        )
        finish()
    }
}