package com.example.seventhtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var messages = mutableListOf<Message>()
    private var adapter = MessageAdapter(messages, this::onMessageItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        fabAdd.setOnClickListener{
            val message = Message(edtTitle.text.toString(), edtText.text.toString())
            messages.add(message)
            adapter.notifyItemInserted(messages.lastIndex)
            edtTitle.text?.clear()
            edtText.text?.clear()
        }
    }

    private fun initRecyclerView(){
        rvMessages.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvMessages.layoutManager = layoutManager
    }

    fun onMessageItemClick(message: Message){
        val string = "${message.title}\n ${message.text}"
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }
}