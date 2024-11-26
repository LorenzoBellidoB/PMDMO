package com.example.cinemaparoomiso.Composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import com.example.cinemaparoomiso.DAL.ConfiguracionEntity
import com.example.cinemaparoomiso.MainActivity.Companion.cineDb
import kotlinx.coroutines.launch

@Composable
fun pantallaConfig(navController: NavHostController){
    var numSalas by remember { mutableStateOf("") }
    var numAsientos by remember { mutableStateOf("") }
    var precioPalomitas by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = numSalas
            , onValueChange = {numSalas = it}
            , label = {Text("Numero de salas")}
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        OutlinedTextField(value = numAsientos
            , onValueChange = {numAsientos = it}
            , label = {Text("Numero de asientos")}
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        OutlinedTextField(value = precioPalomitas
            , onValueChange = {precioPalomitas = it}
            , label = {Text("Precio de las palomitas")}
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        Button(onClick =
        {
            coroutineScope.launch {
                cineDb.configuracionDao().insertarConfiguracion(
                    ConfiguracionEntity(
                        numSalas = numSalas.toInt(),
                        numAsientos = numAsientos.toInt(),
                        precioPalomitas = precioPalomitas.toFloat()
                    )
                )
            }
            navController.navigate("salas")

        },
            enabled = numSalas.isNotEmpty() && numAsientos.isNotEmpty() && precioPalomitas.isNotEmpty()) {
            Text(text = "Guardar")

        }

    }
}