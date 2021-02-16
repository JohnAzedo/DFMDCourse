package com.example.fourthtask01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ButtonsFragment.ChangeColorListener {
    private var colorsFragment: ColorsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        colorsFragment = frag_colors as ColorsFragment
    }

    override fun changeColor(color: Int) {
        colorsFragment?.setColor(color)
    }
}