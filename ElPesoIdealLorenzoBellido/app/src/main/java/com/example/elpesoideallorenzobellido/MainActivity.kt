package com.example.elpesoideallorenzobellido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elpesoideallorenzobellido.Composables.MiAltura
import com.example.elpesoideallorenzobellido.Composables.MiLogin
import com.example.elpesoideallorenzobellido.Composables.MiPeso
import com.example.elpesoideallorenzobellido.ui.theme.ElPesoIdealLorenzoBellidoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ElPesoIdealLorenzoBellidoTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") { MiLogin(navController) }
                    composable("altura/{nombre}/{sexo}") {backStackEntry ->
                        MiAltura(navController,
                            nombre = backStackEntry.arguments?.getString("nombre" ?: ""),
                            sexo = backStackEntry.arguments?.getString("sexo" ?: "")
                        ) }
                    composable("resultado/{nombre}/{sexo}/{peso}/{altura}") {backStackEntry ->
                        MiPeso(navController,
                            nombre = backStackEntry.arguments?.getString("nombre" ?: ""),
                            sexo = backStackEntry.arguments?.getString("sexo" ?: ""),
                            peso = backStackEntry.arguments?.getString("peso" ?: ""),
                            altura = backStackEntry.arguments?.getString("altura" ?: "")
                        ) }
                }

            }
        }
    }
}
