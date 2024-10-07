package com.example.listacontactos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactos = listOf(
            Contacto("Juan", "652567565", 1),
            Contacto("Marco", "652567765", 0),
            Contacto("Raul", "652234765", 0),
            Contacto("Hector", "655367765", 0),
            Contacto("Pablo", "652567765", 0),
            Contacto("Edu", "652753765", 1),
            Contacto("Lorenzo", "623567765", 0),
            Contacto("Ruben", "652567765", 1),
            Contacto("Amaru", "652567465", 1),

        )

        val adapter =ContactosAdapter(contactos)
        val recycleView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.listaContacto)
        recycleView.adapter = adapter
        recycleView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }
}


