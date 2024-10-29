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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stonepapersscissors.R

@Preview
@Composable
fun Inicio(){

    Column(Modifier.background(Color.Red).fillMaxSize().padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
        Ordenador()
        Enfrentamiento()
        Botonera()
    }

}


@Composable
fun Enfrentamiento(){
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Button(onClick = {},
            Modifier.width(150.dp).height(70.dp)) {
            Text("Luchar",
                fontSize = 22.sp)
        }
    }
}
@Composable
fun Ordenador(){
    Row(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp)) {
        Image(painterResource(R.drawable.pc),
            contentDescription = "Ordenador",
            Modifier.fillMaxSize())
    }
}


@Composable
fun Botonera(){
var eleccion = ""
    Row (modifier = Modifier.background(Color.Red).fillMaxWidth().height(70.dp),
        Arrangement.SpaceEvenly){

        Image(
            painterResource(R.drawable.rock),
            contentDescription = "Piedra",
            if(eleccion == "Piedra"){
                Modifier.clickable { eleccion = "Piedra" }.background(Color.Yellow)
            }else{
                Modifier.clickable { eleccion = "Piedra" }
            }

        )
        Image(
            painterResource(R.drawable.paper),
            contentDescription = "Papel",
            if(eleccion == "Piedra"){
                Modifier.clickable { eleccion = "Papel" }.background(Color.Yellow)
            }else{
                Modifier.clickable { eleccion = "Papel" }
            }
        )
        Image(
            painterResource(R.drawable.scissors),
            contentDescription = "Tijera",
            if(eleccion == "Piedra"){
                Modifier.clickable { eleccion = "Tijera" }.background(Color.Yellow)
            }else{
                Modifier.clickable { eleccion = "Tijera" }
            }
        )

    }
}




