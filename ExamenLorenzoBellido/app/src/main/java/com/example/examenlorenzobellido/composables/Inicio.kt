package com.example.examenlorenzobellido.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.examenlorenzobellido.MainActivity.Companion.database
import com.example.examenlorenzobellido.dal.JugadorEntity

// Pantalla de inicio con una lista de jugadores y un botón para agregar jugadores nuevo
@Composable
fun pantallaInicio(navController: NavController){
    var jugadores = remember { mutableStateListOf<JugadorEntity>() }
    var jugador: JugadorEntity = JugadorEntity()
    var coroutineScope = rememberCoroutineScope()
    var id: Int = 0
    LaunchedEffect(Unit) {
        jugadores.clear()
        jugadores.addAll(database.jugadoresDao().obtenerJugadorOrdenados())
    }

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState).padding(16.dp)) {
        jugadores.forEach { item ->
            filasLista(item, navController)
        }
        Button(onClick = {
            navController.navigate("crearJugador")
        }
        ) { Text("Agregar Jugador") }
    }

}

@Composable
fun filasLista(item: JugadorEntity, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                navController.navigate("detalleJugador/${item.id}")
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = item.nombre + " " + item.puntos)
    }
}