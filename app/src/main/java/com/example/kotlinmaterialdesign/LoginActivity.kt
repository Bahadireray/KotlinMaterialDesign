package com.example.kotlinmaterialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun backToHome(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        this.overridePendingTransition(
            R.anim.animation_leave,
            R.anim.anim_slide_out_right
        )
        finish()
    }


    fun signUp(view: View) {
        val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
        startActivity(intent)
        this.overridePendingTransition(
            R.anim.animation_enter, R.anim.anim_slide_out_left
        )
        finish()
    }
}