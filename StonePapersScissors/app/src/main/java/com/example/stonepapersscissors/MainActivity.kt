package com.example.stonepapersscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.stonepapersscissors.Composables.Clasificacion
import com.example.stonepapersscissors.Composables.Ganador
import com.example.stonepapersscissors.Composables.Inicio
import com.example.stonepapersscissors.Composables.Login
import com.example.stonepapersscissors.dal.JugadoresDatabase
import com.example.stonepapersscissors.ui.theme.StonePapersScissorsTheme

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: JugadoresDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar la base de datos
        database = Room.databaseBuilder(
            applicationContext,
            JugadoresDatabase::class.java,
            "jugadores-db"
        ).build()
        enableEdgeToEdge()
        setContent {
            StonePapersScissorsTheme {
                // Controlador de navegación
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") { Login(navController) }
                    composable("inicio/{username}") { backStackEntry ->
                        Inicio(
                            navController,
                            backStackEntry.arguments?.getString("username")
                        )
                    }

                    composable("ganador/{final}") { backStackEntry ->
                        Ganador(
                            navController,
                            backStackEntry.arguments?.getString("final")
                        )
                    }

                    composable("clasificacion/{username}") { backStackEntry ->
                        Clasificacion(
                            navController,
                            backStackEntry.arguments?.getString("username")
                        )
                    }

                }
            }
        }
    }
}



