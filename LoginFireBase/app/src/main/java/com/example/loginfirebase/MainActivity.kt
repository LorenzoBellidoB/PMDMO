package com.example.loginfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginfirebase.composables.inicio
import com.example.loginfirebase.composables.login
import com.example.loginfirebase.composables.paginaError
import com.example.loginfirebase.ui.theme.LoginFireBaseTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFireBaseTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login" 
                ) {
                    composable("login") { login(navController) }
                    composable("inicio") { backStackEntry ->
                        inicio(
                            navController
                        )
                    }

                    composable("error") { backStackEntry ->
                        paginaError(
                            navController
                        )
                    }
                }
            }
        }
    }
}
