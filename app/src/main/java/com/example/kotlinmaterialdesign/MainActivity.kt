package com.example.kotlinmaterialdesign

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text="merhaba"


    }
    fun homeBtn(view: View)
    {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
}