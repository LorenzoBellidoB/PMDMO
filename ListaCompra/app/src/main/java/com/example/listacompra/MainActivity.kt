package com.example.listacompra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listacompra.Composables.VistaCarrito
import com.example.listacompra.Composables.VistaProductos
import com.example.listacompra.ui.theme.ListaCompraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaCompraTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "productos"
                ) {
                    composable("productos") { VistaProductos(navController) }
                    composable("carrito/{resultado}") {backStackEntry ->
                        VistaCarrito(navController,
                            backStackEntry.arguments?.getString("resultado"?: "").toString()
                        ) }

                }
            }
        }
    }
}

