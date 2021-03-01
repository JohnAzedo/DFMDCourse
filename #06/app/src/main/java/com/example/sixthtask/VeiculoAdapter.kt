package com.example.sixthtask

import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_veiculo.view.*

class VeiculoAdapter(private var context: Context, private var veiculos: List<Veiculo>): BaseAdapter() {

    private val logos: TypedArray by lazy{
        context.resources.obtainTypedArray(R.array.logos)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val veiculo = veiculos[position]
        val holder: ViewHolder
        val row: View

        if(convertView==null){
            row = LayoutInflater.from(context).inflate(R.layout.item_veiculo, parent, false)
            holder = ViewHolder(row)
            row.tag = holder
        }else{
            row = convertView
            holder = convertView.tag as ViewHolder
        }
        holder.imgLogo.setImageDrawable(logos.getDrawable(veiculo.fabricante))
        holder.txtModelo.text = veiculo.modelo
        holder.txtAno.text = veiculo.ano.toString()
        holder.txtCombustivel.text = context.getString(this.getCombus(veiculo))


        return row
    }
    override fun getItem(position: Int): Any = veiculos[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = veiculos.size

    private fun getCombus(veiculo: Veiculo): Int =
        if(veiculo.etanol && veiculo.etanol) R.string.combos_flex
        else if (veiculo.gasolina) R.string.combos_gasolina
        else if (veiculo.etanol) R.string.combos_etanol
        else R.string.combos_nao_informado


    companion object {
        data class ViewHolder(val view: View){
            val imgLogo: ImageView = view.imgLogo
            val txtModelo: TextView = view.txtModelo
            val txtAno: TextView = view.txtAno
            val txtCombustivel: TextView = view.txtCombustivel
        }
    }
}