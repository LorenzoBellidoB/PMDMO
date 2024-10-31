package com.example.stonepapersscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stonepapersscissors.Composables.Ganador
import com.example.stonepapersscissors.Composables.Inicio
import com.example.stonepapersscissors.ui.theme.StonePapersScissorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StonePapersScissorsTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ) {
                    composable("inicio") { Inicio(navController) }
                    composable("ganador/{ganador}") {backStackEntry ->
                        Ganador(navController,
                            backStackEntry.arguments?.getString("ganador"?: "") ) }
                }

                }
            }
        }
    }



