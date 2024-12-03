package com.example.examenlorenzobellido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.examenlorenzobellido.composables.crearJugador
import com.example.examenlorenzobellido.composables.crearPartida
import com.example.examenlorenzobellido.composables.detalle
import com.example.examenlorenzobellido.composables.historialPartidas
import com.example.examenlorenzobellido.composables.pantallaInicio
import com.example.examenlorenzobellido.dal.AjedrezDatabase
import com.example.examenlorenzobellido.ui.theme.ExamenLorenzoBellidoTheme

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: AjedrezDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        database = Room.databaseBuilder(
            applicationContext,
            AjedrezDatabase::class.java,
            "ajedrez_db"
        ).build()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenLorenzoBellidoTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ){
                    composable("inicio"){
                        pantallaInicio(navController)

                    }
                    composable("detalleJugador/{id}")
                        {backStackEntry ->
                            detalle(navController,
                                id = backStackEntry.arguments?.getString("id" ?: ""))
                    }
                    composable("crearJugador"){
                        crearJugador(navController)
                    }
                    composable("nuevaPartida/{id}"){backStackEntry ->
                        crearPartida(navController,
                            id = backStackEntry.arguments?.getString("id" ?: ""))
                    }
                    composable("historial/{id}")
                    {backStackEntry ->
                        historialPartidas(navController,
                            id = backStackEntry.arguments?.getString("id" ?: ""))
                    }
                }
            }
        }
    }
}
