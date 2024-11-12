package com.example.stonepapersscissors.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stonepapersscissors.MainActivity.Companion.database
import com.example.stonepapersscissors.R
import com.example.stonepapersscissors.dal.JugadorEntity

// Clase para representar un jugador en el ranking
@Composable
fun Clasificacion(navController: NavController, username: String?){
    val listaJugadores = remember { mutableStateListOf<JugadorEntity>() }
    LaunchedEffect(Unit) {
        listaJugadores.clear()
        listaJugadores.addAll(database.jugadorDao().getAll())
    }
    Column(Modifier.background(Fondo())) {
       RankingScreen(listaJugadores, navController, username)
    }

}

// Función para mostrar el ranking
@Composable
fun RankingScreen(listaJugadores: List<JugadorEntity>, navController: NavController, username: String?) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp).background(Fondo())) {

        Image(
            painter = painterResource(R.drawable.baseline_west_24),
            contentDescription = "Ranking",
            Modifier.fillMaxWidth()
                .padding(15.dp)
                .size(40.dp)
                .clickable { navController.navigate("inicio/${username}") },
            alignment = Alignment.TopStart
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Nombre",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Jugadas",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Ganadas",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }
        HorizontalDivider()

        LazyColumn(Modifier.padding(top = 5.dp).background(Fondo())) {
            items(listaJugadores) { jugador ->
                RankingItem(jugador)
            }
        }
    }
}

// Función para mostrar un jugador en el ranking
@Composable
fun RankingItem(jugador: JugadorEntity) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(Fondo())) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = jugador.name,
                modifier = Modifier.weight(1f)
            )
            Text(text = jugador.partidasJugadas.toString(),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center)
            Text(text = jugador.partidasGanadas.toString(),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End)
        }
        HorizontalDivider()
    }
}