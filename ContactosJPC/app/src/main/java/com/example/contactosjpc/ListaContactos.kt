package com.example.contactosjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.example.contactosjpc.Composables.ItemList

class ListaContactos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
            Contacto("Papa", "695927259", 0),
            Contacto("Cristiano", "652545675", 0)

            )
        setContent{
            MaterialTheme{
                ItemList(contactos)
            }
        }
    }
}