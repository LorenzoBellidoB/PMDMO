package com.example.contactosbd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.contactosbd.ui.theme.ContactosBDTheme
import com.example.listacontactosbd.composables.Agregar
import com.example.listacontactosbd.composables.ItemList
import com.example.listacontactosbd.composables.SimpleLogin
import com.example.listacontactosbd.dal.PersonasDatabase

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: PersonasDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            applicationContext,
            PersonasDatabase::class.java,
            "personas-db"
        ).build()
        enableEdgeToEdge()
        setContent {
            ContactosBDTheme {
                // Controlador de navegación
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        SimpleLogin(navController)
                    }
                    composable("contactos") {
                        ItemList(navController)
                    }
                    composable("agregar") {
                        Agregar(navController)
                    }
                    }

                }
            }
        }
    }
