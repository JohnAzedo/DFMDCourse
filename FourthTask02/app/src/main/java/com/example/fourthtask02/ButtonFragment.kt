package com.example.fourthtask02

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class ButtonFragment : Fragment() {
    private var listener: IncrementListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is IncrementListener){
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag_button, container, false)
        view.findViewById<Button>(R.id.btn_inc).setOnClickListener({
            listener?.orderIncrement()
        })
        return view
    }


    interface IncrementListener{
        fun orderIncrement()
    }
}