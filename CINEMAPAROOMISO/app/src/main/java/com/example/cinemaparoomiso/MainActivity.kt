package com.example.cinemaparoomiso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.cinemaparoomiso.Composable.pantallaConfig
import com.example.cinemaparoomiso.Composable.pantallaSala
import com.example.cinemaparoomiso.DAL.CineDatabase
import com.example.cinemaparoomiso.ui.theme.CINEMAPAROOMISOTheme

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var cineDb: CineDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cineDb = Room.databaseBuilder(
            applicationContext,
            CineDatabase::class.java,
            "cine-db"
        ).build()
        enableEdgeToEdge()
        setContent {
            CINEMAPAROOMISOTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "configuracion"
                ) {
                    composable("configuracion") { pantallaConfig(navController) }
                    composable("salas") { backStackEntry ->
                        pantallaSala(
                            navController
                        )
                    }

                    /*composable("asistencia") { backStackEntry ->
                        Ganador(
                            navController
                        )
                    }

                    composable("detalleSala") { backStackEntry ->
                        Clasificacion(
                            navController
                        )
                    }*/
                }
            }
        }
    }
}
