package com.example.stonepapersscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.stonepapersscissors.Composables.Inicio
import com.example.stonepapersscissors.ui.theme.StonePapersScissorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StonePapersScissorsTheme {

                Inicio()

                }
            }
        }
    }



