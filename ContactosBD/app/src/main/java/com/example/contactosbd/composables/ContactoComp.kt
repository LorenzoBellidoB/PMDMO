package com.example.listacontactosbd.composables

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.contactosbd.MainActivity.Companion.database
import com.example.contactosbd.R
import com.example.listacontactosbd.dal.PersonaEntity

// Funcion que muestra la lista de contactos
@Composable
fun ItemList(navController: NavController) {
    var listaPersonas = remember{ mutableStateListOf<PersonaEntity>() }
    LaunchedEffect(Unit) {
        listaPersonas.clear()
        listaPersonas.addAll(database.personaDao().getAll())
    }

    Column(Modifier.fillMaxSize().background(Color(142, 202, 255)).padding(top =20.dp).padding(10.dp),verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(listaPersonas) { itemContacto ->
                ContactoView(contacto = itemContacto, navController)
            }
        }
        Row(Modifier.fillMaxWidth().padding(top =40.dp), horizontalArrangement = Arrangement.Center) {
            OutlinedButton(onClick = {
                navController.navigate("agregar")

            },Modifier.width(200.dp)) { Text("Agregar", fontSize = 20.sp, color = Color.Black) }
        }
    }

}

// Funcion que muestra la vista de un contacto segun los datos de la base de datos
@Composable
fun ContactoView(contacto: PersonaEntity, navController: NavController) {
    var mostrar by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    var foto = R.drawable.man
    if (contacto.sexo == 2) {
      foto = R.drawable.women
    }
    Card(Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color(51, 111, 216))) {
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
                    // Boton para llamar al contacto mediante el número telefono
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

                    // Boton para editar el contacto y que muestre el nombre completo
                } else {
                    val iniciales: String = contacto.nombre.uppercase().subSequence(0, 2).toString()
                    Text(iniciales, fontSize = 50.sp)
                    Log.d(":::Contactos", mostrar.toString())

                }
            }

        }

    }
}