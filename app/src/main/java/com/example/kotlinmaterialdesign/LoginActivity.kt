package com.example.kotlinmaterialdesign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

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

    fun login(view: View) {
        val sharedPreferences = this.getSharedPreferences(
            "com.example.kotlinmaterialdesign",
            Context.MODE_PRIVATE
        )
        var etUserName = etUserName.text.toString()
        var etPassword = etPassword.text.toString()

        val shUserName = sharedPreferences.getString("myUserName", "")
        val shPassword = sharedPreferences.getString("myPassword", "")
        if (etUserName == shUserName && etPassword == shPassword) {
            Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Bilgileriniz Yanlış", Toast.LENGTH_LONG).show()
        }
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