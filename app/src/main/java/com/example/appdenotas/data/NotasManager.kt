package com.example.appdenotas.data

import com.example.appdenotas.model.Nota

object NotasManager {
    private val listaNotas = mutableListOf<Nota>()

    fun agregarNota(nota: Nota) {
        listaNotas.add(nota)
    }

    fun obtenerNotas(): List<Nota> {
        return listaNotas
    }

    fun eliminarNota(nota: Nota) {
        listaNotas.remove(nota)
    }
}
