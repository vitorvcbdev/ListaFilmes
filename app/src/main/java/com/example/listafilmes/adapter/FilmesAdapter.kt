package com.example.listafilmes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listafilmes.R
import com.example.listafilmes.model.Filmes

class FilmesAdapter(private val filmes: List<Filmes>):
    RecyclerView.Adapter<FilmesAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txvTituloFilme = itemView.findViewById<TextView>(R.id.txv_titulo_filme)
        val txvGeneroFilme = itemView.findViewById<TextView>(R.id.txv_genero_filme)
        val txvAvaliacaoFilme = itemView.findViewById<TextView>(R.id.txv_avaliacao_filme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txvTituloFilme.text = filme.titulo
        holder.txvGeneroFilme.text = filme.genero
        holder.txvAvaliacaoFilme.text = filme.avaliacao.toString()
    }
}