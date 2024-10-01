package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.MainActivity.Companion.nombre

class Calculadora : AppCompatActivity() {

    companion object{
        lateinit var bienvenido: TextView
        lateinit var num1: EditText
        lateinit var num2: EditText
        lateinit var res: TextView
        lateinit var suma: Button
        lateinit var resta: Button
        lateinit var division: Button
        lateinit var multiplicacion: Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora1)
        val user = intent.getStringExtra("usuario")
        Log.d(":::Calc", "Usuario " + user)
        bienvenido = findViewById<TextView>(R.id.bienvenido)
        bienvenido.setText("Bienvenido " + user)

        suma = findViewById<Button>(R.id.suma)
        resta = findViewById<Button>(R.id.resta)
        multiplicacion = findViewById<Button>(R.id.multiplicar)
        division = findViewById<Button>(R.id.dividir)

        num1 = findViewById<EditText>(R.id.num1)
        num2 = findViewById<EditText>(R.id.num2)
        res = findViewById<TextView>(R.id.res)

        suma.setOnClickListener{
            var numero1 = num1.text.toString()
            var numero2 = num2.text.toString()

            if(numero1.isNotEmpty() && numero2.isNotEmpty()){
                var num1Long = numero1.toLongOrNull()
                var num2Long = numero2.toLongOrNull()

                if(num1Long != null && num2Long != null){
                    var resultado = num1Long + num2Long
                    res.text = resultado.toString()
                }
            }
        }

        resta.setOnClickListener{
            var numero1 = num1.text.toString()
            var numero2 = num2.text.toString()

            if(numero1.isNotEmpty() && numero2.isNotEmpty()){
                var num1Long = numero1.toLongOrNull()
                var num2Long = numero2.toLongOrNull()

                if(num1Long != null && num2Long != null){
                    var resultado = num1Long - num2Long
                    res.text = resultado.toString()
                }
            }
        }

        multiplicacion.setOnClickListener{
            var numero1 = num1.text.toString()
            var numero2 = num2.text.toString()

            if(numero1.isNotEmpty() && numero2.isNotEmpty()){
                var num1Long = numero1.toLongOrNull()
                var num2Long = numero2.toLongOrNull()

                if(num1Long != null && num2Long != null){
                    var resultado = num1Long * num2Long
                    res.text = resultado.toString()
                }
            }
        }

        division.setOnClickListener{
            var numero1 = num1.text.toString()
            var numero2 = num2.text.toString()

            if(numero1.isNotEmpty() && numero2.isNotEmpty()){
                var num1Long = numero1.toLongOrNull()
                var num2Long = numero2.toLongOrNull()

                if(num1Long != null && num2Long != null){
                    var resultado = num1Long / num2Long

                    res.text = resultado.toString()
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        Log.d(":::Calc" , "Operacones")
    }
}