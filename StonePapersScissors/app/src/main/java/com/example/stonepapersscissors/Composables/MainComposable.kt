package com.example.stonepapersscissors.Composables

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stonepapersscissors.MainActivity.Companion.database
import com.example.stonepapersscissors.R
import com.example.stonepapersscissors.dal.JugadorEntity
import kotlinx.coroutines.launch
import kotlin.random.Random

// Función para mostrar la pantalla de inicio
@Composable
fun Inicio(navController: NavController, username: String?){
    var eleccion by remember { mutableStateOf("") }

    var jugador = JugadorEntity()

    var jugadorEleccion by remember { mutableStateOf(0) }

    var mostrar by remember { mutableStateOf(false) }

    var luchar by remember { mutableStateOf(false) }

    var ordenador by remember { mutableStateOf(0) }

    var ganador by remember { mutableStateOf(0) }

    var puntosJ by remember { mutableStateOf(0) }

    var puntosO by remember { mutableStateOf(0) }

    val listaJugadores = remember { mutableStateListOf<JugadorEntity>() }
    LaunchedEffect(Unit) {
        listaJugadores.clear()
        listaJugadores.addAll(database.jugadorDao().getAll())
    }
    jugador = listaJugadores.find { it.name == username } ?: JugadorEntity()


    Column(Modifier.background(Fondo()).fillMaxSize().padding(10.dp,40.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Ordenador()

        if(luchar){

            Log.d(":::EleccionO", "$ordenador")
            Image(
                painterResource(ordenador),
                contentDescription = "Eleccion",
                Modifier.width(120.dp)
            )


        }

        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            var final = ""
            val context = LocalContext.current
            val coroutineScope = rememberCoroutineScope()

            Button(onClick = {luchar = true
                ordenador = Elegir()
                ganador = DeterminarGanador(jugadorEleccion,ordenador)
                if(ganador == 1){
                    puntosJ += 1
                    jugador.luchasGanadas += 1

                    coroutineScope.launch {
                        database.jugadorDao().actualizar(jugador)
                    }

                    Toast.makeText(context,"Gana el jugador",Toast.LENGTH_SHORT).show()
                }else if(ganador == -1){
                    puntosO += 1
                    Toast.makeText(context,"Gana el ordenador",Toast.LENGTH_SHORT).show()

                }else {
                    puntosJ += 1
                    puntosO += 1
                    jugador.luchasGanadas += 1

                    coroutineScope.launch {
                        database.jugadorDao().actualizar(jugador)
                    }

                    Toast.makeText(context,"Empate",Toast.LENGTH_SHORT).show()
                }
                if(puntosJ == 5){
                    jugador.partidasGanadas += 1
                    jugador.partidasJugadas += 1

                    coroutineScope.launch {
                        database.jugadorDao().actualizar(jugador)
                    }

                    final = jugador.name
                    navController.navigate("ganador/${final}")
                }else if(puntosO == 5){
                    jugador.partidasJugadas += 1

                    coroutineScope.launch {
                        database.jugadorDao().actualizar(jugador)
                    }

                    final = "Ordenador"
                    navController.navigate("ganador/${final}")
                }
                },
                Modifier.width(150.dp).height(70.dp),
                enabled = mostrar) {
                Text("Luchar",
                    fontSize = 22.sp)
            }
            Log.d(":::Puntos", "$ganador")
        }

        if(mostrar){
            Log.d(":::EleccionJ", "$jugadorEleccion")
            Image(
                painterResource(jugadorEleccion),
                contentDescription = "Eleccion",
                Modifier.width(120.dp)
            )
        }

        Row (modifier = Modifier.fillMaxWidth().height(80.dp),
            Arrangement.SpaceEvenly) {

            Image(
                painterResource(R.drawable.rock),
                contentDescription = "Piedra",
                Modifier.clickable {
                    eleccion = "Piedra"
                    jugadorEleccion = R.drawable.rock
                    mostrar = true
                }

            )
            Image(
                painterResource(R.drawable.paper),
                contentDescription = "Papel",
                Modifier.clickable {
                    eleccion = "Papel"
                    jugadorEleccion = R.drawable.paper
                    mostrar = true
                }
            )
            Image(
                painterResource(R.drawable.scissors),
                contentDescription = "Tijeras",
                Modifier.clickable {
                    eleccion = "Tijeras"
                    jugadorEleccion = R.drawable.scissors
                    mostrar = true
                }
            )
        }
    }

}

// Función para mostrar el ordenador
@Composable
fun Ordenador(){
    Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        Image(painterResource(R.drawable.pc),
            contentDescription = "Ordenador",
            Modifier.fillMaxSize())
    }
}

// Función para poner el fondo con un gradiente
@Composable
fun Fondo():Brush{
    val gradiente = Brush.radialGradient(
        0.0f to Color(200,120,150),
        1.0f to Color(80,20,35),
        radius = 1500.0f,
        tileMode = TileMode.Repeated
    )
    return gradiente
}

// Función para elegir una opción aleatoria
fun Elegir(): Int {
    val num = Random.nextInt(1, 4)
    var painter = 0
    if(num == 1){
        painter = R.drawable.rock
    }else if(num == 2){
        painter = R.drawable.paper
    }else{
        painter = R.drawable.scissors
    }

    return painter
}

// Función para determinar el ganador
fun DeterminarGanador(jugador: Int, ordenador: Int): Int {
    return if (jugador == ordenador) {
        0
    }
    else if ((jugador == R.drawable.rock && ordenador == R.drawable.scissors) || (jugador == R.drawable.paper && ordenador == R.drawable.rock) || (jugador == R.drawable.scissors && ordenador == R.drawable.paper))
    {
        1
    }
    else {
        -1
    }
}