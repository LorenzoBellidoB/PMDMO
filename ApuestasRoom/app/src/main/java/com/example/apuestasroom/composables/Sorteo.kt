package com.example.apuestasroom.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apuestasroom.MainActivity.Companion.apuestasDb
import com.example.apuestasroom.R
import com.example.apuestasroom.dal.JugadorEntity
import com.example.apuestasroom.dal.SorteoEntity

@Composable
fun sorteo(navController: NavController) {

    var numGanador1 by remember { mutableStateOf(0) }
    var numGanador2 by remember { mutableStateOf(0) }
    var listaGanadores by remember { mutableStateOf(mutableListOf<JugadorEntity>()) }
    val backgroundPainter = painterResource(R.drawable.dall_e_2024_12_02_11_11)

    // Generar números ganadores
    numGanador1 = aleatorio(1, 10)
    numGanador2 = aleatorio(1, 10)

    // Insertar sorteo en la base de datos
    LaunchedEffect(numGanador1, numGanador2) {
        apuestasDb.sorteosDao()
            .insert(SorteoEntity(numGanador1 = numGanador1, numGanador2 = numGanador2))
    }

    // Obtener lista de ganadores
    LaunchedEffect(numGanador1, numGanador2) {
        listaGanadores =
            apuestasDb.jugadoresDao().obtenerGanadores(numGanador1, numGanador2).toMutableList()
    }

    // Fondo con temática de apuestas
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = "Fondo de apuestas",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 28.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sección de ganadores
            if (listaGanadores.isEmpty()) {
                Text(
                    text = "¡No hay ganadores!",
                    color = Color.Red,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🎉 Jugadores Ganadores 🎉",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        items(listaGanadores.size) { index ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFF4CAF50),
                                    contentColor = Color.White
                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "${listaGanadores[index].id} -",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(end = 8.dp)
                                    )
                                    Text(
                                        text = listaGanadores[index].nombre,
                                        fontSize = 18.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Números ganadores
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🎲 Números Ganadores 🎲",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Cyan
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Número ganador 1: $numGanador1",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Blue
                )
                Text(
                    text = "Número ganador 2: $numGanador2",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Blue
                )
                Button(onClick = {navController.navigate("inicio")}) { Text("Volver") }
            }
        }
    }
}

// Función auxiliar para generar un número aleatorio
fun aleatorio(min: Int, max: Int): Int {
    return (min..max).random()
}
