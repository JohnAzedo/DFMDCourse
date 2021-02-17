package com.example.fourthtask02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment: Fragment() {
    private var txtView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag_counter, container, false)
        txtView = view.findViewById<TextView>(R.id.txt_counter)
        return view
    }

    fun increment(){
        val valor: Int = txtView?.text.toString().toInt()+1
        txtView?.text = valor.toString()
    }
}