package com.example.myapplication // Asegúrate de que este sea el paquete correcto

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetallesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        // Obtener los datos del Intent
        val nombre = intent.getStringExtra("nombre") ?: ""
        val fecha = intent.getStringExtra("fecha") ?: ""
        val imagenUri = intent.getStringExtra("imagen")
        val tel = intent.getStringExtra("tel") ?: ""
        val email = intent.getStringExtra("email") ?: ""
        val descripcion = intent.getStringExtra("descripcion") ?: ""

        // Mostrar los datos en los TextView
        findViewById<TextView>(R.id.tvNombre).text = "Nombre: $nombre"
        findViewById<TextView>(R.id.tvFecha).text = "Fecha: $fecha"
        findViewById<TextView>(R.id.tvTel).text = "Teléfono: $tel"
        findViewById<TextView>(R.id.tvEmail).text = "Email: $email"
        findViewById<TextView>(R.id.tvDescripcion).text = "Descripción: $descripcion"


    }
}