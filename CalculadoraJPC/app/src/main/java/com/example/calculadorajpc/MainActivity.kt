package com.example.calculadorajpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculadorajpc.Composables.VistaHome
import com.example.calculadorajpc.Composables.VistaResultado
import com.example.calculadorajpc.ui.theme.CalculadoraJPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraJPCTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { VistaHome(navController) }
                    composable("resultado/{resultado}") {backStackEntry ->
                        VistaResultado(navController,
                            backStackEntry.arguments?.getString("resultado"?: "") ) }
                }

            }
        }
    }
}

