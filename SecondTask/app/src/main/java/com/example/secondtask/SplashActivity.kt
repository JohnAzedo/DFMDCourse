package com.example.secondtask

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        this.supportActionBar?.hide()

        Thread {
            SystemClock.sleep(1000)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }.start()

    }
}