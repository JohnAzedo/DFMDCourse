package com.example.fourthtask01

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frag_buttons.*

class ButtonsFragment : Fragment(), View.OnClickListener {
    private var listener: ChangeColorListener? = null;

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is ChangeColorListener){
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag_buttons, container, false)
        view.findViewById<Button>(R.id.btn_black).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_blue).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_green).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_red).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_yellow).setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        val color: Int = when(view?.id){
            R.id.btn_black -> Color.BLACK
            R.id.btn_blue -> Color.BLUE
            R.id.btn_green -> Color.GREEN
            R.id.btn_red -> Color.RED
            R.id.btn_yellow -> Color.YELLOW
            else -> Color.GRAY
        }

        listener?.changeColor(color)
    }

    interface ChangeColorListener{
        fun changeColor(color: Int)
    }
}