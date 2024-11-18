package com.example.listacontactosbd.composables

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.listacontactosbd.MainActivity.Companion.database
import com.example.listacontactosbd.R
import com.example.listacontactosbd.dal.PersonaEntity
import kotlinx.coroutines.launch


@Composable
fun ItemList(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var listaPersonas = rememberSaveable { mutableListOf<PersonaEntity>() }
    LaunchedEffect(Unit) {
        listaPersonas.clear()
        listaPersonas.addAll(database.personaDao().getAll())
    }
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {     // produce una lista de desplazamiento vertical,
        items(listaPersonas) { itemContacto ->
            ContactoView(contacto = itemContacto, navController)
        }
    }
    Row {
        Button(onClick = {
            navController.navigate("agregar")
            coroutineScope.launch {
                listaPersonas.clear()
                listaPersonas.addAll(database.personaDao().getAll())
            }
        }) { Text("Agregar") }
    }
}

@Composable
fun ContactoView(contacto: PersonaEntity, navController: NavController) {
    var mostrar by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    Log.d(":::Contactos", mostrar.toString())
    var foto = R.drawable.men
    if (contacto.sexo == 1) {
      foto = R.drawable.women
    }
    Card(Modifier.fillMaxWidth()) {
        Row {
            Column {
                Image(painter = painterResource(id = foto), contentDescription = "Foto contacto",
                    modifier = Modifier.height(100.dp).clickable { mostrar = !mostrar })

            }
            Column {
                Log.d(":::Contactos", mostrar.toString())

                if (mostrar) {
                    Log.d(":::Contactos", mostrar.toString())
                    Text(
                        text = contacto.nombre,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = contacto.telefono,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp).clickable {
                            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.CALL_PHONE), 1)
                            } else {
                                navController.navigate("login/")
                            }
                        }
                    )

                } else {
                    val iniciales: String = contacto.nombre.uppercase().subSequence(0, 2).toString()
                    Text(iniciales, fontSize = 50.sp)
                    Log.d(":::Contactos", mostrar.toString())
                }
            }

        }

    }
}