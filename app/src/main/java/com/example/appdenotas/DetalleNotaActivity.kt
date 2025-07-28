package com.example.appdenotas

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.appdenotas.data.NotasManager
import com.example.appdenotas.model.Nota

class DetalleNotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_nota)

        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etContenido = findViewById<EditText>(R.id.etContenido)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)

        val notaRecibida = intent.getSerializableExtra("nota") as? Nota

        if (notaRecibida != null) {
            etTitulo.setText(notaRecibida.titulo)
            etContenido.setText(notaRecibida.contenido)

            btnGuardar.setOnClickListener {
                val notaActualizada = Nota(
                    id = notaRecibida.id,
                    titulo = etTitulo.text.toString(),
                    contenido = etContenido.text.toString(),
                    fechaCreacion = System.currentTimeMillis()
                )
                NotasManager.actualizarNota(notaActualizada)
                finish()
            }

            btnEliminar.setOnClickListener {
                NotasManager.eliminarNota(notaRecibida.id)
                finish()
            }

        } else {
            btnEliminar.isEnabled = false

            btnGuardar.setOnClickListener {
                val nuevaNota = Nota(
                    id = System.currentTimeMillis(),
                    titulo = etTitulo.text.toString(),
                    contenido = etContenido.text.toString(),
                    fechaCreacion = System.currentTimeMillis()
                )
                NotasManager.agregarNota(nuevaNota)
                finish()
            }
        }
    }




}
