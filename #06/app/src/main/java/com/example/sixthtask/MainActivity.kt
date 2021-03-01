package com.example.sixthtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val veiculos = mutableListOf<Veiculo>(
        Veiculo("Onix", 2018, 1, true, true),
        Veiculo("Uno", 2007, 2, true, false),
        Veiculo("Del Rey", 1998, 3, false, true),
        Veiculo("Gol", 2014, 0, false, false),
        Veiculo("Uno", 2007, 2, true, false),
        Veiculo("Del Rey", 1998, 3, false, true),
        Veiculo("Gol", 2014, 0, false, false),
        Veiculo("Uno", 2007, 2, true, false),
        Veiculo("Del Rey", 1998, 3, false, true),
        Veiculo("Gol", 2014, 0, false, false)
    )

    private lateinit var adapter: VeiculoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = ListView(this)
        setContentView(listView)

        adapter = VeiculoAdapter(this, veiculos)
        listView.adapter = adapter
    }
}