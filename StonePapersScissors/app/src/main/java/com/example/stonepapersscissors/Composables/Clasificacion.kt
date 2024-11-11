package com.example.stonepapersscissors.Composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.weight
import com.example.stonepapersscissors.MainActivity.Companion.database
import com.example.stonepapersscissors.dal.JugadorEntity

@Composable
fun Clasificacion(){
    val listaJugadores = remember { mutableStateListOf<JugadorEntity>() }
    LaunchedEffect(Unit) {
        listaJugadores.clear()
        listaJugadores.addAll(database.jugadorDao().getAll())
    }

    val listaOrdenada = listaJugadores.sortByDescending { it.partidasGanadas }
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { // Header row
            Row {
                Text("Ranking", fontWeight = FontWeight.Bold, modifier = Modifier.weight(
                    1f
                ))
                Text("Nombre", fontWeight = FontWeight.Bold, modifier = Modifier.weight(
                    1f
                ))
                Text("Victorias", fontWeight = FontWeight.Bold, modifier = Modifier.weight(
                    1f
                ))
            }
        }


    }
}