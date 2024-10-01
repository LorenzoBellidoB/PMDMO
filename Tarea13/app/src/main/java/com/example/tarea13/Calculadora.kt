package com.example.tarea13

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        val user = intent.getStringExtra("usuario")
        var acceso = Intent(this, MainActivity::class.java)

        if(user == "Lorenzo"){
            //acesso = Intent(this, Calculadora::class.java)
        }
    }
}