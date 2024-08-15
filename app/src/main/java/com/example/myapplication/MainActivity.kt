package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var fecha: EditText
    private var imageButton: ImageButton? = null
    private var datePicker: DatePicker? = null
    private lateinit var tel: EditText
    private lateinit var email: EditText
    private lateinit var descripcion: EditText
    private lateinit var button: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nombre = findViewById(R.id.nombre)
        fecha = findViewById(R.id.Fecha)
        imageButton = findViewById(R.id.imageButton)
        datePicker = findViewById(R.id.datePicker)
        tel = findViewById(R.id.Tel)
        email = findViewById(R.id.email)
        descripcion = findViewById(R.id.descripcion)
        button = findViewById(R.id.button)

        fecha.setText(getFechaDatePicker())

        datePicker?.setOnDateChangedListener { _, anio, mes, dia ->
            val diaStr = dia.toString().padStart(2, '0')
            val mesStr = (mes + 1).toString().padStart(2, '0')
            val anioStr = anio.toString().padStart(4, '0')
            fecha.setText("$diaStr/$mesStr/$anioStr")
            datePicker?.visibility = View.GONE
        }

        button.setOnClickListener {
            val intent = Intent(this, DetallesActivity::class.java)
            intent.putExtra("nombre", nombre.text.toString())
            intent.putExtra("fecha", fecha.text.toString())
            intent.putExtra("imagen", imageButton?.tag as? String)
            intent.putExtra("tel", tel.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("descripcion", descripcion.text.toString())
            startActivity(intent)
        }
    }

    private fun getFechaDatePicker(): String {
        val dia = datePicker?.dayOfMonth.toString().padStart(2, '0')
        val mes = (datePicker?.month?.plus(1)).toString().padStart(2, '0')
        val anio = datePicker?.year.toString().padStart(4, '0')
        return "$dia/$mes/$anio"
    }

    fun muestraCalendario(view: View) {
        datePicker?.visibility = View.VISIBLE
    }
}