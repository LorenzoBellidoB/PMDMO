package com.example.tarea13

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var nombre: EditText
        lateinit var boton: Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nombre = findViewById<EditText>(R.id.usuario)
        boton = findViewById<Button>(R.id.botonId)

        boton.setOnClickListener{
            setContentView(R.layout.bienvenida)
        }

        Log.d(":::Vida", "He creado el onCreate()")

    }

    override fun onStart() {
        super.onStart()
        Log.d(":::Vida", "He creado el onStart()")
    }

    override fun onResume() {
        super.onResume()
        val toast = Toast.makeText(this, "Bienvenido de nuevo, " + nombre.text, Toast.LENGTH_SHORT)
        toast.show()
        Log.d(":::Vida" , "He creado el onResume()")
    }

//    override fun onPause() {
//        super.onPause()
//        setContentView(R.layout.pausa)
//        Log.d(":::Vida" , "He creado el onPause()")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(":::Vida" , "He creado el onStop()")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(":::Vida" , "He creado el onDestroy()")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(":::Vida" , "He creado el onRestart()")
//    }
}