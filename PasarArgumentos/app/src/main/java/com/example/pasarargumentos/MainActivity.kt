package com.example.pasarargumentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pasarargumentos.ui.theme.PasarArgumentosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasarArgumentosTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { VistaHome(navController) }
                    composable("numero/{userid}") { backStackEntry ->
                        VistaNumero(userId = backStackEntry.arguments?.getString("userId"))
                    }

                    /* .Gráfico de navegación. */
                }

            }
        }
    }
}

@Composable
fun VistaHome(navControllerHome : NavController){

    Button(onClick = { navControllerHome.navigate("numero") }) {
        Text("Ir a Numero")
    }

}

@Composable
fun VistaNumero(navControllerHome : NavController){

    Button(onClick = { navControllerHome.navigate("numero") }) {
        Text("Ir a Numero")
    }

}