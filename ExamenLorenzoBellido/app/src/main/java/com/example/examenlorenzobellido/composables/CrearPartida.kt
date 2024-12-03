package com.example.examenlorenzobellido.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.examenlorenzobellido.MainActivity.Companion.database
import com.example.examenlorenzobellido.dal.JugadorEntity
import com.example.examenlorenzobellido.dal.PartidaEntity
import kotlinx.coroutines.launch
import java.time.LocalDate

// Pantalla de creación de una nueva partida con un botón para crear una nueva partida nueva con los datos introducidos
@Composable
fun crearPartida(navController: NavController, id: String?) {


    var courutineScope = rememberCoroutineScope()

    var jugadores = remember { mutableStateListOf<JugadorEntity>() }

    var id1 by remember { mutableStateOf(id.toString()) }

    var id2 by remember { mutableStateOf("") }

    var resultado by remember { mutableStateOf("") }

    var fecha by remember { mutableStateOf(fechaActual()) }

    LaunchedEffect(Unit) {
        jugadores.clear()
        jugadores.addAll(database.jugadoresDao().obtenerJugadorOrdenados())
    }

    Column(Modifier.padding(20.dp)) {
        // no me ha dado tiempo para hacer el desplegable
        OutlinedTextField(value = id2.toString(), onValueChange = {id2 = it}, label = { Text("Id Jugador 2")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Row {
            Button(onClick = {resultado = "1"}) { Text("Victoria") }
            Button(onClick = {resultado = "0"}) { Text("Empate") }
            Button(onClick = {resultado = "-1"}) { Text("Derrota") }
        }
        OutlinedTextField(value = fecha, onValueChange = {fecha = it}, label = { Text("Fecha")})
        Button(onClick = {
            courutineScope.launch {
                database.partidasDao().insertar(PartidaEntity(jugador1 = id1.toInt(), jugador2 = id2.toInt(), resultado = resultado.toInt(), fecha = fecha))
                navController.navigate("inicio")
            }
        }, enabled = (!id1.isNullOrEmpty() && !id2.isNullOrEmpty() && fecha.isNotEmpty() && !resultado.isNullOrEmpty())) { Text("Crear Partida") }
    }
}


private fun fechaActual(): String {
    val current = LocalDate.now()
    return current.toString()
}













// Intento de desplegable
/*
@Composable
fun crearPartida(navController: NavController, id: String?){

var mExpanded by remember { mutableStateOf(false) }

var listaJugadores = remember { mutableStateListOf<JugadorEntity>() }

    var idOponente: Int by remember { mutableStateOf("") }

var mSelectedText by remember { mutableStateOf("") }

var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

val icon = if (mExpanded)
    Icons.Filled.KeyboardArrowUp
else
    Icons.Filled.KeyboardArrowDown

Column(Modifier.padding(20.dp)) {

    OutlinedTextField(
        value = mSelectedText,
        onValueChange = { mSelectedText = it },
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->

                mTextFieldSize = coordinates.size.toSize()
            },
        label = {Text("Label")},
        trailingIcon = {
            Icon(icon,"contentDescription",
                Modifier.clickable { mExpanded = !mExpanded })
        }
    )

    DropdownMenu(
        expanded = mExpanded,
        onDismissRequest = { mExpanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
    ) {
        listaJugadores.forEach { label ->
            DropdownMenuItem(text = { Text(text = "Oponente") },
                onClick = {
                mSelectedText = label.nombre

                mExpanded = false
            })
        }
    }
}
}*/