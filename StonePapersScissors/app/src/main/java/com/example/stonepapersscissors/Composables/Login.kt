package com.example.stonepapersscissors.Composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stonepapersscissors.MainActivity.Companion.database
import com.example.stonepapersscissors.dal.JugadorEntity
import kotlinx.coroutines.launch

@Composable
fun Login(navController: NavController){
    var username by remember { mutableStateOf("") }
    var jugador: JugadorEntity = JugadorEntity()
    val coroutineScope = rememberCoroutineScope()
    val listaJugadores = remember { mutableStateListOf<JugadorEntity>() }
    LaunchedEffect(Unit) {
        listaJugadores.clear()
        listaJugadores.addAll(database.jugadorDao().getAll())
    }

    Column (Modifier.fillMaxSize().background(Color.Gray).padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Row {
            TextField(value = username,
                onValueChange = {username = it},
                placeholder ={ Text("Usuario") }
            )
        }
        Button(onClick = {
            navController.navigate("inicio/${username}")
            coroutineScope.launch {
                jugador.name = username
                for (jugador in listaJugadores) {
                    if (jugador.name != username) {
                        database.jugadorDao().insertar(jugador)
                    }
                }

            }
        }, enabled = !username.isNullOrEmpty()
        ) {
            Text("Jugar")
        }
    }
}