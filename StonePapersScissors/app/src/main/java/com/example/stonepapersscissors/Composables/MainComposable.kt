package com.example.stonepapersscissors.Composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stonepapersscissors.R
import kotlin.random.Random

@Preview
@Composable
fun Inicio(){
    var eleccion by remember { mutableStateOf("") }

    var jugador by remember { mutableStateOf(0) }

    var mostrar by remember { mutableStateOf(false) }

    var luchar by remember { mutableStateOf(false) }

    var ordenador by remember { mutableStateOf(0) }

    var puntos by remember { mutableStateOf(0) }


    Column(Modifier.background(Fondo()).fillMaxSize().padding(10.dp,40.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Ordenador()

        if(luchar){
            ordenador = Elegir()
            Log.d(":::EleccionO", "$ordenador")
            Image(
                painterResource(ordenador),
                contentDescription = "Eleccion",
                Modifier.width(120.dp)
            )
            puntos = DeterminarGanador(jugador,ordenador)
        }

        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = {luchar = true
                             ordenador = 0},
                Modifier.width(150.dp).height(70.dp),
                enabled = mostrar) {
                Text("Luchar",
                    fontSize = 22.sp)
            }
        }

        if(mostrar){
            Log.d(":::EleccionJ", "$jugador")
            Image(
                painterResource(jugador),
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
                    jugador = R.drawable.rock
                    mostrar = true
                }

            )
            Image(
                painterResource(R.drawable.paper),
                contentDescription = "Papel",
                Modifier.clickable {
                    eleccion = "Papel"
                    jugador = R.drawable.paper
                    mostrar = true
                }
            )
            Image(
                painterResource(R.drawable.scissors),
                contentDescription = "Tijeras",
                Modifier.clickable {
                    eleccion = "Tijeras"
                    jugador = R.drawable.scissors
                    mostrar = true
                }
            )
        }
    }

}


@Composable
fun Ordenador(){
    Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        Image(painterResource(R.drawable.pc),
            contentDescription = "Ordenador",
            Modifier.fillMaxSize())
    }
}



@Composable
fun Fondo():Brush{
    val gradiente = Brush.radialGradient(
        0.0f to Color.Gray,
        1.0f to Color.Black,
        radius = 1500.0f,
        tileMode = TileMode.Repeated
    )
    return gradiente
}

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