package com.example.appdenotas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdenotas.R
import com.example.appdenotas.model.Nota
import java.text.SimpleDateFormat
import java.util.*

class NotasAdapter(private var listaNotas: List<Nota>, private val onNotaClick: (Nota) -> Unit) : RecyclerView.Adapter<NotasAdapter.NotaViewHolder>() {

    inner class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFecha)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nota, parent, false)
        return NotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val nota = listaNotas[position]
        holder.tvTitulo.text = nota.titulo

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        holder.tvFecha.text = sdf.format(Date(nota.fechaCreacion))

        holder.itemView.setOnClickListener {
            onNotaClick(nota)
        }
    }

    override fun getItemCount(): Int = listaNotas.size

    fun actualizarLista(nuevaLista: List<Nota>) {
        listaNotas = nuevaLista
        notifyDataSetChanged()
    }
}
