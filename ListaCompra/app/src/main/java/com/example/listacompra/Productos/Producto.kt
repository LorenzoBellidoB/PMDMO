package com.example.listacompra.Productos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter

class Producto(val nombre: String, val precio: Double,val painter: Painter) {
    var cantidad by mutableIntStateOf(0)
}