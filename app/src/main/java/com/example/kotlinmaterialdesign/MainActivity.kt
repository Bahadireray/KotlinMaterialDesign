package com.example.kotlinmaterialdesign

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : CountDownTimer(1500, 1400) {
            override fun onTick(millisUntilFinished: Long) {
                imageViewBig.animate().apply {
                    duration = 1000
                    rotationXBy(360f)
                }.start()
                imageViewSmall.animate().apply {
                    duration = 1000
                    rotationXBy(360f)
                }.start()
            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.xml.no_animation, R.xml.slide_down)
                finish()
            }
        }.start()
    }
}