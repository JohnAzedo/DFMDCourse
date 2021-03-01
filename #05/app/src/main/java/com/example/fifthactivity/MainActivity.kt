package com.example.fifthactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), AlimentoFragment.OnItemClickAlimento{
    private var textFragment: TextFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFragment = supportFragmentManager.findFragmentById(R.id.frag_text) as TextFragment
    }

    override fun onClickAlimento(alimento: Alimento) {
        textFragment?.setTxt("O preço do ${alimento} é R$ ${alimento.preco}")
    }
}