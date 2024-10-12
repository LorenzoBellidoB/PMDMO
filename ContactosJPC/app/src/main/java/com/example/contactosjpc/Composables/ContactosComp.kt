package com.example.contactosjpc.Composables

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.contactosjpc.Contacto
import com.example.contactosjpc.R
import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat


@Composable
fun ItemList(itemContacto: List<Contacto>) {
    LazyColumn {    // produce una lista de desplazamiento vertical,
        items(itemContacto) { itemContacto ->
            ContactoView(contacto = itemContacto)
        }
    }
}

@Composable
fun ContactoView(contacto: Contacto) {
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
                        text = contacto.name,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = contacto.tfno,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp).clickable {
                            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.CALL_PHONE), 1)
                            } else {
                                val intent = Intent(Intent.ACTION_CALL)
                                intent.data = Uri.parse("tel:${contacto.tfno}")
                                ContextCompat.startActivity(context, intent, null)
                            }
                        }
                    )

                } else {
                    val iniciales: String = contacto.name.uppercase().subSequence(0, 2).toString()
                    Text(iniciales, fontSize = 50.sp)
                    Log.d(":::Contactos", mostrar.toString())
                }

            }
        }
    }
}