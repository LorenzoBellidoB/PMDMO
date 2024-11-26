package com.example.cinemaparoomiso.Composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cinemaparoomiso.DAL.ConfiguracionEntity
import com.example.cinemaparoomiso.MainActivity.Companion.cineDb
import kotlin.random.Random

@Composable
fun pantallaSala(navController: NavHostController){
    var listaConfiguraciones = remember { mutableStateListOf<ConfiguracionEntity>() }
    LaunchedEffect(Unit) {
        listaConfiguraciones.clear()
        listaConfiguraciones.addAll(cineDb.configuracionDao().obtenerConfiguraciones())
    }
    Column(Modifier.fillMaxSize()) {
        navBar(navController = navController)
    }
}

@Composable
fun navBar(navController: NavHostController){
    Row(Modifier.fillMaxWidth().padding(top = 15.dp), horizontalArrangement = Arrangement.Center) {
        Button(onClick = {}, enabled = !(navController.currentDestination?.route).equals("salas")) { Text("Salas") }
        Button(onClick = {}, enabled = !(navController.currentDestination?.route).equals("asistencia")) { Text("Asistencia") }
        Button(onClick = {},enabled = !(navController.currentDestination?.route).equals("detalleSala")) { Text("Detalle Sala") }
    }
}

fun salaAleatoria(listaConfiguraciones: List<ConfiguracionEntity>): Int{
    var numeroSalas: Int = listaConfiguraciones.count()

    var salaRandom: Int = Random.nextInt(numeroSalas +1)

    return salaRandom
}

fun numeroPersonas(): Int{
    var personas: Int = Random.nextInt(5+1)

    return personas
}