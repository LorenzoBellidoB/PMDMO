package com.example.contactosjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjpc.ui.theme.ContactosJPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                ItemList(
                    itemContacto = listOf(
                        Contacto("Juan", "652567565", 1),
                        Contacto("Marco", "652567765", 0),
                        Contacto("Raul", "652234765", 0),
                        Contacto("Hector", "655367765", 0),
                        Contacto("Pablo", "652567765", 0),
                        Contacto("Edu", "652753765", 1),
                        Contacto("Lorenzo", "623567765", 0),
                        Contacto("Ruben", "652567765", 1),
                        Contacto("Pablo", "652567765", 0),
                        Contacto("Edu", "652753765", 1),
                        Contacto("Lorenzo", "623567765", 0),
                        Contacto("Ruben", "652567765", 1),
                        Contacto("Amaru", "652567465", 1)
                    )
                )
            }
        }
    }
}


@Composable
fun ItemList(itemContacto: List<Contacto>) {
    LazyColumn {	// produce una lista de desplazamiento vertical,
        items(itemContacto) { itemContacto ->
            ContactoView(contacto = itemContacto)
        }}}



@Composable
fun ContactoView(contacto: Contacto) {
    var foto = R.drawable.men
    if(contacto.sexo == 1){
        foto = R.drawable.women
    }
    Card(Modifier.fillMaxWidth()) {
        Row {
                    Column {
                        Image(
                            painter = painterResource(id = foto),
                            contentDescription = "Foto contacto",
                            Modifier.height(100.dp)
                        )
                    }
                    Column {
                        Text(
                            text = contacto.name,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text = contacto.tfno,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(8.dp)
                        )}}}}
