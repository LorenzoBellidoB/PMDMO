package com.example.examenlorenzobellido.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.examenlorenzobellido.MainActivity.Companion.database
import com.example.examenlorenzobellido.dal.PartidaEntity
import kotlinx.coroutines.launch

// Pantalla de historial de partidas de un jugador con una lista de partidas y un botón para volver al menú principal o crear una nueva partida
@Composable
fun historialPartidas(navController: NavController, id: String?){
    var listaPartidas = remember { mutableStateListOf<PartidaEntity>() }

    var courutineScope = rememberCoroutineScope()

    var oponente by remember { mutableStateOf("") }


    LaunchedEffect(Unit) {
        listaPartidas.clear()
        listaPartidas.addAll(database.partidasDao().obtenerDatosPartidasPorJugador(id.toString().toInt()))
    }

    listaPartidas.forEach { item ->
        courutineScope.launch {
            if (item.jugador1 != id.toString().toInt()) {
                oponente = database.jugadoresDao().obtenerNombre(item.jugador1)
            } else {
                oponente = database.jugadoresDao().obtenerNombre(item.jugador2)
            }
        }
        Column {
            Text("Oponente: $oponente")
            Row {
                if(item.resultado == 1){
                    Text("Victoria")
                }else if(item.resultado == 0){
                    Text("Empate")
                }else{
                    Text("Derrota")
                }
            }

            Text("Fecha: ${item.fecha}")
            Button(onClick = { navController.navigate("nuevaPartida") }) { Text("Nueva Partida") }
            Button(onClick = {navController.navigate("detalleJugador/$id")}) { Text("Volver") }
        }
    }

}