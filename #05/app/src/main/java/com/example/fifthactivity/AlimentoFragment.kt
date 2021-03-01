package com.example.fifthactivity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class AlimentoFragment: ListFragment() {
    private var adapter: ArrayAdapter<Alimento>? = null
    private var activity: OnItemClickAlimento? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnItemClickAlimento){
            activity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1)
        val nomes = requireActivity()
                .resources
                .getStringArray(R.array.alimentos_nome)

        val precos = requireActivity()
                .resources
                .getStringArray(R.array.alimentos_preco)

        for(i in nomes.indices){
            val alimento = Alimento(nomes[i], precos[i].toDouble())
            adapter?.add(alimento)
        }

        listAdapter = adapter;
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        val alimento = adapter?.getItem(position);
        activity?.onClickAlimento(alimento!!)
    }

    interface OnItemClickAlimento{
        fun onClickAlimento(alimento: Alimento);
    }
}