package com.example.appdenotas.model

import java.io.Serializable

data class Nota(
    val id: Long,
    val titulo: String,
    val contenido: String,
    val fechaCreacion: Long = System.currentTimeMillis()
) : Serializable
