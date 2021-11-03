package com.example.ejercicio2_calculadorav2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.Calcular)
        val mensaje = findViewById<TextView>(R.id.textView)
        val num1 = findViewById<EditText>(R.id.editTextNumber)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)
        val spinner = findViewById<Spinner>(R.id.spinner)
        var posicionSpinner = ""

        //Rellenar Spinner
        val operaciones = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, operaciones)
        spinner.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        boton.setOnClickListener {
            val numero1 = num1.text.toString().toInt()
            val numero2 = num2.text.toString().toInt()
            var txt = ""

            when (posicionSpinner) {
                "Sumar" -> txt = ("Resultado: ${numero1 + numero2}")
                "Restar" -> txt = ("Resultado: ${numero1 - numero2}")
                "Multiplicar" -> txt = ("Resultado: ${numero1 * numero2}")
                "Dividir" -> txt = ("Resultado: ${numero1 / numero2}")
            }

            val i = Intent(this, Resultado::class.java)
            i.putExtra("Resultado",txt)
            startActivity(i)
        }

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                posicionSpinner = parent!!.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }
}