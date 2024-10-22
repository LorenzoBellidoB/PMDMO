package com.example.elpesoideallorenzobellido.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.elpesoideallorenzobellido.R


@Composable
fun MiLogin(navControllerLogin: NavController){
    var nombre by rememberSaveable { mutableStateOf("") }
    var sexo by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize().background(Color(160,40,70))
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Imagen 1",
                modifier = Modifier.size(200.dp))
        }
        Row(Modifier.padding(top = 25.dp, bottom = 25.dp)) {
        TextField(
            value = nombre,
            onValueChange = {nombre = it },
            label = { Text("Nombre") }
        )
    }
        Row() {
            Button(onClick = {
                sexo = "Hombre"
                navControllerLogin.navigate("altura/${nombre}/${sexo}")
            },enabled = nombre != "",
                modifier = Modifier.padding(end = 5.dp)
                ) {
                Text("Hombre")
            }
            Button(onClick = {
                sexo = "Mujer"
                navControllerLogin.navigate("altura/${nombre}/${sexo}")
            }, enabled = nombre != ""
            ) {
                Text("Mujer")

            }
        }
    }
}

@Composable
fun MiAltura(navControllerAltura: NavController, nombre: String?, sexo: String?){
    var altura by rememberSaveable { mutableStateOf(0) }
    var peso by rememberSaveable { mutableStateOf(0.0) }
    Column(
        modifier = Modifier.fillMaxSize().background(Color(160,40,70)).padding(top = 20.dp, start = 10.dp),
        horizontalAlignment = Alignment.Start
        ) {
        Row {
            Text("Hola, ${nombre}",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Sexo: ${sexo}")
        }

        Row(modifier = Modifier.padding(top = 30.dp))  {
            TextField(
                value = peso.toString(),
                onValueChange = {peso = it.toDouble() },
                label = {Text("Peso (kg)")}
            )
        }

        Column() {
            Text(
                text = "150cm",
                Modifier.clickable(enabled = altura != 150) {
                    altura = 150
                })
            Text(
                text = "155cm",
                Modifier.clickable(enabled = altura != 155) {
                    altura = 155
                })
            Text(
                text = "160cm",
                Modifier.clickable(enabled = altura != 160) {
                    altura = 160
                })
            Text(
                text = "165cm",
                Modifier.clickable(enabled = altura != 165) {
                    altura =165
                })
            Text(
                text = "170cm",
                Modifier.clickable(enabled = altura != 170) {
                    altura = 170
                })
            Text(
                text = "175cm",
                Modifier.clickable(enabled = altura != 175) {
                    altura = 175
                })
            Text(
                text = "180cm",
                Modifier.clickable(enabled = altura != 180) {
                    altura = 180
                })
            Text(
                text = "185cm",
                Modifier.clickable(enabled = altura != 185) {
                    altura = 185
                })
            Text(
                text = "190cm",
                Modifier.clickable(enabled = altura != 190) {
                    altura = 190
                })
            Text(
                text = "195cm",
                Modifier.clickable(enabled = altura != 195) {
                    altura = 195
                })
            Text(
                text = "200cm",
                Modifier.clickable(enabled = altura != 200) {
                    altura = 200
                })
            Text(
                text = "205cm",
                Modifier.clickable(enabled = altura != 205) {
                    altura = 205
                })
            Text(
                text = "210cm",
                Modifier.clickable(enabled = altura != 210) {
                    altura = 210
                })
            Text(
                text = "215cm",
                Modifier.clickable(enabled = altura != 215) {
                    altura = 215
                })
            Text(
                text = "220cm",
                Modifier.clickable(enabled = altura != 220) {
                    altura = 220
                })

        }

        Row (verticalAlignment = Alignment.Bottom){
            Button(onClick = {
                navControllerAltura.navigate("resultado/${nombre}/${sexo}/${peso}/${altura}")
            }, enabled = peso != 0.0 && altura != 0) {
                Text("Resultado")
            }
        }

    }
}

@Composable
fun MiPeso(navControllerPeso: NavController, nombre: String?, sexo: String?,peso: String?, altura: String?){

    var coeficiente: Double
    var pesoDouble = peso?.toDouble()
    var alturaDouble = altura?.toDouble()
    var resultado by remember { mutableStateOf(0.0) }

    if(nombre.equals("Hombre")){
        coeficiente = 1.0
    }else{
        coeficiente = 0.95
    }

    if (pesoDouble != null) {
        if (alturaDouble != null) {
            resultado = IndiceMasaCorporal(pesoDouble,alturaDouble,coeficiente)
        }
    }

    Column(modifier = Modifier.fillMaxSize().background(Color(160,40,70)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(Modifier.padding(top = 20.dp),verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.End) {
            Image(painter = painterResource(R.drawable.baseline_west_24),
                contentDescription = "Atras",
                Modifier.clickable { navControllerPeso.navigate("login") })
        }
        Column  {
            Column {
                Text("Resultado",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold)
                Text("${resultado}",
                    fontSize = 20.sp)
            }

        }

    }


}

fun IndiceMasaCorporal(peso: Double, altura: Double, coeficiente: Double): Double{
    var alturaMetros = altura/100
    var res = (peso/(alturaMetros*alturaMetros)) * coeficiente

    return res
}