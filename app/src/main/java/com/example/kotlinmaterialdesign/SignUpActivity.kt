package com.example.kotlinmaterialdesign

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    var myEmailId: String? = null
    var myUserName: String? = null
    var myPassword: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun backtohome(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        this.overridePendingTransition(
            R.anim.animation_leave,
            R.anim.anim_slide_out_right
        )
        finish()
    }

    fun signup(view: View) {
        val sharedPreferences = this.getSharedPreferences(
            "com.example.kotlinmaterialdesign",
            Context.MODE_PRIVATE
        )
        myEmailId = edtEmailId.text.toString()
        myUserName = edtUserName.text.toString()
        myPassword = edtPassword.text.toString()

        println("singup geldi")
        if ((myEmailId != "") && (myUserName != "") && (myPassword != "")) {
            val alert = AlertDialog.Builder(this@SignUpActivity)
            alert.setTitle("Kayıt Etmek ister misiniz?")
            alert.setMessage(
                "Bilgileriniz \nEmail: $myEmailId \n" +
                        "User: $myUserName \n" +
                        "Password: $myPassword"
            )
            alert.setPositiveButton("Evet") { dialogInterface: DialogInterface, i: Int ->
                sharedPreferences.edit().putString("myEmailId", myEmailId).apply()
                sharedPreferences.edit().putString("myUserName", myUserName).apply()
                sharedPreferences.edit().putString("myPassword", myPassword).apply()
                Toast.makeText(this, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.overridePendingTransition(
                    R.anim.animation_leave,
                    R.anim.animation_enter
                )
                finish()
            }
            alert.setNegativeButton("Hayır") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "Kayıt Başarısız", Toast.LENGTH_LONG).show()
                println("no")
            }
            alert.show()
        } else {
            Toast.makeText(this, "Boş Değer Girmeyiniz", Toast.LENGTH_LONG).show()
        }


    }
}