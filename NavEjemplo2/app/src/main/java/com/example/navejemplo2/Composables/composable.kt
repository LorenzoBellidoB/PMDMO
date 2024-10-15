package com.example.navejemplo2.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class composable {
    @Composable
    fun Imagen (imagen: Int){
        Image(
            painterResource(id = imagen),
            contentDescription = "Foto 1",
            modifier = Modifier.padding(15.dp))
    }
}