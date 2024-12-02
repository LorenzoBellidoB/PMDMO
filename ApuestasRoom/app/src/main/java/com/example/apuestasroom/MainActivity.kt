package com.example.apuestasroom

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.apuestasroom.composables.Inicio
import com.example.apuestasroom.composables.sorteo
import com.example.apuestasroom.dal.ApuestasDatabase
import com.example.apuestasroom.ui.theme.ApuestasRoomTheme

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var apuestasDb: ApuestasDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        apuestasDb = Room.databaseBuilder(
            applicationContext,
            ApuestasDatabase::class.java,
            "apuesta-db"
        ).build()
        enableEdgeToEdge()
        setContent {
            ApuestasRoomTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ){
                    composable("inicio"){
                        Inicio(navController)
                    }
                    composable("sorteo"){
                        backStackEntry ->
                        sorteo(navController)
                    }
                }
            }
        }
    }
}
