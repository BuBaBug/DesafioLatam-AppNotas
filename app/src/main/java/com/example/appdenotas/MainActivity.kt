package com.example.appdenotas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdenotas.adapter.NotasAdapter
import com.example.appdenotas.data.NotasManager
import com.example.appdenotas.model.Nota
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.widget.SearchView
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

    private lateinit var listaNotasOriginal: List<Nota>
    private lateinit var adapter: NotasAdapter
    private lateinit var notasAdapter: NotasAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchView = findViewById<androidx.appcompat.widget.SearchView>(R.id.searchView)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTareas)
        val fabAgregarNota: MaterialButton = findViewById(R.id.fabAgregarNota)

        listaNotasOriginal = NotasManager.obtenerNotas()
        adapter = NotasAdapter(listaNotasOriginal)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                notasFiltradas(newText)
                return true
            }
        })

        fabAgregarNota.setOnClickListener {
            startActivity(Intent(this, DetalleNotaActivity::class.java))
        }
    }


    override fun onResume() {
        super.onResume()
        listaNotasOriginal = NotasManager.obtenerNotas()
        adapter.actualizarLista(listaNotasOriginal)
    }




    private fun notasFiltradas(texto: String?) {
        val textoBusqueda = texto ?: ""  // Si texto es null, usar cadena vacía

        val notasFiltradas = listaNotasOriginal.filter {
            it.titulo.contains(textoBusqueda, ignoreCase = true) ||
                    it.contenido.contains(textoBusqueda, ignoreCase = true)
        }
        adapter.actualizarLista(notasFiltradas)

        // Mostrar mensaje si no hay resultados
        val tvSinResultados = findViewById<TextView>(R.id.tvSinResultados)
        tvSinResultados.visibility = if (notasFiltradas.isEmpty()) View.VISIBLE else View.GONE
    }


}