package com.example.examenlorenzobellido.composables

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
import androidx.navigation.NavController
import com.example.examenlorenzobellido.MainActivity.Companion.database
import com.example.examenlorenzobellido.dal.JugadorEntity
import kotlinx.coroutines.launch
import java.time.LocalDate

// Pantalla de creación de un nuevo jugador con un botón para crear un nuevo jugador nuevo con los datos introducidos en los campos de texto
@Composable
fun crearJugador(navController: NavController){
    var nombre: String by remember { mutableStateOf("") }
    var puntos: String by remember { mutableStateOf("") }
    var fecha: String by remember { mutableStateOf(fechaActual()) }
    var courutineScope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = nombre, onValueChange = {nombre = it}, label = { Text("Nombre")})
        OutlinedTextField(value = puntos, onValueChange = {puntos = it}, label = { Text("Puntos")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        OutlinedTextField(value = fecha, onValueChange = {fecha = it}, label = { Text("Fecha")})
        Button(onClick = {
            courutineScope.launch {
                database.jugadoresDao().insertar(JugadorEntity(nombre = nombre, puntos = puntos.toInt(), fecha = fecha))
            }
            navController.navigate("inicio")
        }, enabled = (nombre.isNotEmpty() && puntos.isNotEmpty() && fecha.isNotEmpty())) { Text("Guardar") }
    }


}


private fun fechaActual(): String {
    val current = LocalDate.now()
    return current.toString()
}