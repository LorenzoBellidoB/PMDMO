package com.example.listas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.listas.Composables.ItemList
import com.example.listas.ui.theme.ListasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val animales = listOf(
                Animal("Perro", "Descripcion de perro", painterResource(R.drawable.perro)),
                Animal("Gato", "Descripcion de gato", painterResource(R.drawable.gato)),
                Animal("Marco", "Descripcion de Marco", painterResource(R.drawable.marco)),
                Animal("Pato", "Descripcion de perro", painterResource(R.drawable.ic_launcher_background)),
                Animal("Raton", "Descripcion de gato", painterResource(R.drawable.ic_launcher_background)),
                Animal("Canguro", "Descripcion de Marco", painterResource(R.drawable.ic_launcher_background)),
                Animal("Pez", "Descripcion de pez", painterResource(R.drawable.pez))
            )
            setContent{
                MaterialTheme{
                    ItemList(animales)
                }
            }
        }
    }
}

