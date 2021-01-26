package com.example.firsttask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val secondButton: Button = findViewById(R.id.btn_second)
        val bundle: Bundle? = this.intent.extras
        val currentValue: Int? = bundle?.getInt(CURRENT_VALUE_KEY)

        if (currentValue != null) {
            val refreshValue = currentValue + 1
            secondButton.text = refreshValue.toString()
            secondButton.setOnClickListener{
                val backIntent: Intent = Intent().apply {
                    putExtra(CURRENT_VALUE_KEY, refreshValue)
                }
                this.setResult(RESULT_OK, backIntent)
                finish()
            }
        }
    }

    companion object {
        const val RESULT_OK = 1
        const val CURRENT_VALUE_KEY = "CURRENT_VALUE"

    }
}