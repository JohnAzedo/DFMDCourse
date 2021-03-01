package com.example.fifthactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TextFragment: Fragment(){

    private var txtLF: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_text, container, false);
        txtLF = view.findViewById(R.id.txt_fl)
        return view
    }

    fun setTxt(text: String){
        txtLF?.text = text
    }
}