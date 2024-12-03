package com.example.examenlorenzobellido.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.examenlorenzobellido.MainActivity.Companion.database
import com.example.examenlorenzobellido.dal.JugadorEntity
import com.example.examenlorenzobellido.dal.PartidaEntity

// Pantalla de detalle de un jugador con su nombre, número de partidas jugadas y puntos totales
@Composable
fun detalle(navController: NavController, id: String?) {
    var jugadorId: Int
    var numeroPartidas: Int by remember { mutableStateOf(0 ) }
    var jugador: JugadorEntity by remember { mutableStateOf(JugadorEntity()) }
    Column (Modifier.fillMaxSize().padding(16.dp)) {


    if(id.isNullOrEmpty()){
        jugadorId = 0
    }else{
        jugadorId = id.toInt()
    }
    if(jugadorId != 0){
        LaunchedEffect(Unit) {
            numeroPartidas = database.partidasDao().obtenerPartidasPorJugador(jugadorId)
            jugador = database.jugadoresDao().obtenerJugadorPorId(jugadorId)!!
        }
        if (jugador != null){
            Text(text = jugador.nombre)
            Text(text = numeroPartidas.toString())
            Text(text = jugador.puntos.toString())
            Text(text = jugador.fecha)

        }else{
            Text(text = "Jugador no existe")
        }
    }else{
        Text(text = "Id de Jugador no comprendido")
    }
        Button(onClick = {
            navController.navigate("nuevaPartida/$id")
        }) {
            Text("Nueva Partida")
        }
        Button(onClick = {navController.navigate("historial/$id")}) { Text("Historial") }

    }
}