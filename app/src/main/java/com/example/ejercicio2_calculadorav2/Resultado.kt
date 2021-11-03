package com.example.ejercicio2_calculadorav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultado = intent.extras?.getString("Resultado")

        val mensaje = findViewById<TextView>(R.id.textView2)
        mensaje.text = resultado.toString()
    }
}