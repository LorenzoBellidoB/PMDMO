package com.example.apuestasroom.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.apuestasroom.R

@Preview
@Composable
fun Inicio() {
    var jugador by remember { mutableStateOf("") }
    var numElegido1 by remember { mutableStateOf(0) }
    var numElegido2 by remember { mutableStateOf(0) }
    val backgroundPainter = painterResource(R.drawable.dall_e_2024_12_02_11_11)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 10.dp)
        ) {
            // Campo de texto para el nombre del jugador
            OutlinedTextField(
                value = jugador,
                onValueChange = { jugador = it },
                label = { Text("Jugador") },
                modifier = Modifier.fillMaxWidth()
            )

            // Sección de botones con selección de números
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Fila 1 de botones
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(16.dp)) {
                        NumButton(1, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                        NumButton(2, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                        NumButton(3, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                    }
                    // Fila 2 de botones
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(16.dp)) {
                        NumButton(4, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                        NumButton(5, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                        NumButton(6, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                    }
                    // Fila 3 de botones
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(16.dp)) {
                        NumButton(7, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                        NumButton(8, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                        NumButton(9, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                    }
                    // Fila 4 de botones
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(16.dp)) {
                        NumButton(10, numElegido1, numElegido2) { num ->
                            if (numElegido1 == 0) numElegido1 = num else numElegido2 = num
                        }
                    }
                    Button(onClick = {}) { Text("Apostar") }
                }
            }
        }
    }
}

@Composable
fun NumButton(number: Int, numElegido1: Int, numElegido2: Int, onClick: (Int) -> Unit) {
    Button(
        onClick = { onClick(number) },
        enabled = (numElegido1 == 0 || numElegido2 == 0),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .size(70.dp)
    ) {
        Text(
            text = number.toString(),
            color = Color.Black,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
