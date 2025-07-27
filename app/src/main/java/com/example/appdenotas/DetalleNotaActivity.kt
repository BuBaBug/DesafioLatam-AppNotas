package com.example.appdenotas

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.appdenotas.data.NotasManager
import com.example.appdenotas.model.Nota


class DetalleNotaActivity : AppCompatActivity() {

    private lateinit var etTitulo: EditText
    private lateinit var etContenido: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnEliminar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_nota)

        etTitulo = findViewById(R.id.etTitulo)
        etContenido = findViewById(R.id.etContenido)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnEliminar = findViewById(R.id.btnEliminar)

        // Guardar la nueva nota
        btnGuardar.setOnClickListener {
            val titulo = etTitulo.text.toString().trim()
            val contenido = etContenido.text.toString().trim()

            if (titulo.isNotEmpty()) {
                val nuevaNota = Nota(
                    id = System.currentTimeMillis(),
                    titulo = titulo,
                    contenido = contenido
                )

                NotasManager.agregarNota(nuevaNota)
                Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "El título no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
        }


        // Eliminar no tiene sentido en una nota nueva
        btnEliminar.setOnClickListener {
            Toast.makeText(this, "No hay nota para eliminar", Toast.LENGTH_SHORT).show()
        }
    }
}
