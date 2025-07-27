package com.example.appdenotas.data

import com.example.appdenotas.model.Nota

object NotasManager {
    private val listaNotas = mutableListOf<Nota>()

    fun obtenerNotas(): List<Nota> = listaNotas

    fun agregarNota(nota: Nota) {
        listaNotas.add(nota)
    }

    fun actualizarNota(notaActualizada: Nota) {
        val index = listaNotas.indexOfFirst { it.id == notaActualizada.id }
        if (index != -1) {
            listaNotas[index] = notaActualizada
        }
    }

    fun eliminarNota(id: Long) {
        listaNotas.removeAll { it.id == id }
    }
}
