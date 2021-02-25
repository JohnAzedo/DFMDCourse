package com.example.firsttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstButton: Button = findViewById(R.id.btn_first)

        firstButton.setOnClickListener{
            val currentValue: Int? = Integer.parseInt(firstButton.text.toString())
            val intent: Intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(CURRENT_VALUE_KEY, currentValue)
            }
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val currentValue: Int? = data?.getIntExtra(CURRENT_VALUE_KEY, 2)
        val refreshValue: Int? = currentValue?.plus(1)
        val firstButton: Button = findViewById(R.id.btn_first)

        firstButton.text = refreshValue.toString()
    }

    override fun onResume() {
        Log.i("MainActivity", "Method onResume")
        super.onResume()
    }

    override fun onRestart() {
        Log.i("MainActivity", "Method onRestart")
        super.onRestart()
    }

    override fun onStart() {
        Log.i("MainActivity", "Method onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.i("MainActivity", "Method onStop")
        super.onStop()
    }

    override fun onPause() {
        Log.i("MainActivity", "Method onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.i("MainActivity", "Method onDestroy")
        super.onDestroy()
    }

    companion object {
        const val REQUEST_CODE = 1
        const val CURRENT_VALUE_KEY = "CURRENT_VALUE"
    }
}