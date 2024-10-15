package com.example.listas.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.listas.Animal

@Composable
fun ItemList(itemAnimal: List<Animal>){
    LazyColumn {
        items(itemAnimal){itemAnimal ->
            AnimalView(animal = itemAnimal)
        }

    }
}

@Composable
fun AnimalView(animal: Animal) {
    var mostrar by rememberSaveable { mutableStateOf(false) }
    Column {
        Text(text = animal.nombre,
            modifier = Modifier.padding(10.dp)
                .clickable { mostrar = !mostrar }
        )
        Image(
            painter = animal.imagen,
            contentDescription = "Imagen",
            Modifier.width(100.dp).height(100.dp)
        )


}
    if(mostrar){
        Popup(alignment = Alignment.BottomCenter) {
            Box(){
                Text(text = animal.descripcion,
                modifier = Modifier.background(Color.White).fillMaxWidth())
            }
        }
    }
}


