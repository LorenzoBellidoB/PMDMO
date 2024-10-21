package com.example.calculadorajpc.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.calculadorajpc.R

@Composable
fun VistaHome(navControllerHome : NavHostController){
    var num1 by remember { mutableIntStateOf(0) }
    var num2 by remember { mutableIntStateOf(0) }
    Column(Modifier.padding(20.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen",
            Modifier.size(100.dp).clip(CircleShape).background(Color.Gray)
        )
        TextField(
            value = num1.toString(),
            onValueChange = {num1 = it.toIntOrNull() ?: 0 },
            label = { Text("Primer Factor") }
        )
        TextField(
            value = num2.toString(),
            onValueChange = {num2 = it.toIntOrNull() ?: 0 },
            label = { Text("Segundo Factor") }
        )

        var res = suma(Integer.valueOf(num1),Integer.valueOf(num2))

        Button(onClick = {navControllerHome.navigate("resultado/${res}")}) {
            Text("Resultado")
        }

    }
}

@Composable
fun VistaResultado(navController: NavHostController, resultado: String?) {
    Column(Modifier.padding(50.dp)) {
        Text("Resultado")
        if (resultado != null) {
            Text(resultado)
        }
    }
}

fun suma(num1: Int,num2: Int): Int {
    return num1 + num2
}