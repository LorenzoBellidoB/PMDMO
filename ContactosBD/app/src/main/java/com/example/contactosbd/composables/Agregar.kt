package com.example.listacontactosbd.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactosbd.MainActivity.Companion.database
import com.example.listacontactosbd.dal.PersonaEntity
import kotlinx.coroutines.launch

// Funcion que muestra la pantalla de agregar un contacto
@Composable
fun Agregar(navController: NavController) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var telefono by rememberSaveable { mutableStateOf("") }
    var sexo by rememberSaveable { mutableStateOf(0) }
    var persona: PersonaEntity = PersonaEntity()
    val coroutineScope = rememberCoroutineScope()


    Column(
        Modifier.background(Color(142, 202, 255)).padding(20.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column() {
            TextField(value = nombre, onValueChange = { nombre = it }, placeholder = { Text("Nombre") })

            TextField(value = telefono,
                onValueChange = { telefono = it },
                placeholder = { Text("Telefono") })
        }


        Row() {
            Button(onClick = { sexo = 1 },Modifier.width(100.dp), enabled = sexo != 1, colors = ButtonDefaults.buttonColors(containerColor = Color(0, 52, 143))) {
                Text("Hombre")
            }

            Button(onClick = { sexo = 2 },Modifier.width(100.dp), enabled = sexo != 2, colors = ButtonDefaults.buttonColors(containerColor = Color(0, 52, 143))) {
                Text("Mujer")
            }
        }

        Row {
            // Instancio la corrutina para poder acceder a la base de datos y agregar el contacto
            Button(onClick = {
                persona.nombre = nombre;
                persona.telefono = telefono;
                persona.sexo = sexo;
                coroutineScope.launch {
                    database.personaDao().insertar(persona)
                }
                navController.navigate("contactos") }
                , Modifier.padding(top = 20.dp), enabled = nombre != "" && telefono != "" && sexo != 0, colors = ButtonDefaults.buttonColors(containerColor = Color(0, 52, 143)) ) { Text("Guardar")
            }
            Button(onClick = {

                navController.navigate("contactos") }
                , Modifier.padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0, 52, 143))) { Text("Volver")
            }
        }
        }

}