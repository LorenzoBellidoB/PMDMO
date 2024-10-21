package com.example.calculadorajpc.Composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.calculadorajpc.R

@Composable
fun VistaHome(navControllerHome : NavController){
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var res by remember { mutableDoubleStateOf(0.0) }
    val context:Context = LocalContext.current
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen",
            Modifier.size(100.dp).clip(CircleShape).background(Color.Gray)
        )
        TextField(
            value = num1,
            onValueChange = {num1 = it },
            label = { Text("Primer Factor") }
        )
        TextField(
            value = num2,
            onValueChange = {num2 = it },
            label = { Text("Segundo Factor") }
        )


        Row(Modifier.padding(top = 100.dp)) {

            Button( onClick = {
                if(num1=="" && num2 == ""){
                    num1 = "0"
                    num2 = "0"
                }
                res = suma(num1.toDouble(),num2.toDouble());
                navControllerHome.navigate("resultado/${res.toString()}")
            }) {
                Text("Suma")
            }

            Button(onClick = {
                if(num1=="" && num2 == ""){
                    num1 = "0"
                    num2 = "0"
                }
                res = resta(num1.toDouble(),num2.toDouble())
                navControllerHome.navigate("resultado/${res.toString()}")
            }) {
                Text("Resta")
            }

            Button(onClick = {
                if(num1=="" && num2 == ""){
                    num1 = "0"
                    num2 = "0"
                }
                res = multiplicacion(num1.toDouble(),num2.toDouble())
                navControllerHome.navigate("resultado/${res.toString()}")
            }) {
                Text("Multiplicacion")
            }

            Button(onClick = {
                if(num1=="" && num2 == ""){
                    num1 = "0"
                    num2 = "0"
                }
                res = division(num1.toDouble(),num2.toDouble(), context)
                navControllerHome.navigate("resultado/${res.toString()}")
            }) {
                Text("Division")
            }
        }

    }
}

@Composable
fun VistaResultado(navControllerResultado: NavController, resultado: String?) {
    Column() {

            Image(
                painter = painterResource(R.drawable.baseline_west_24),
                contentDescription = "Pa Tras" ,
                Modifier.clickable {navControllerResultado.popBackStack() }.padding(top = 30.dp).size(30.dp)
            )


            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text("Resultado: ${resultado}",
                    fontSize = 24.sp)

            }



    }
}


fun suma(num1: Double,num2: Double): Double {
    return num1 + num2
}

fun resta(num1: Double,num2: Double): Double {
    return num1 - num2
}

fun multiplicacion(num1: Double,num2: Double): Double {
    return num1 * num2
}

fun division(num1: Double,num2: Double,contexto: Context): Double {
    if(num2 == 0.0){
        val toast = Toast.makeText(contexto, "This is a Sample Toast", Toast.LENGTH_LONG)
        toast.show()
    }
    return num1/num2
}