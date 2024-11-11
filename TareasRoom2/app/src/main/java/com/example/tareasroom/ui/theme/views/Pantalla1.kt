package com.example.tareasroom.ui.theme.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.tareasroom.MainActivity.Companion.database
import com.example.tareasroom.dal.TareaEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@Composable
fun nuevaTarea(coroutineScope: CoroutineScope, lista: MutableList<TareaEntity>){
    var texto by remember { mutableStateOf("") }

    Row {
        TextField(
            value = texto,
            onValueChange = {
                texto = it
            },
            label = {
                Text("Nueva tarea")
            }
        )
        Button(onClick = {
            var tarea = TareaEntity()
            tarea.name = texto
            coroutineScope.launch {
                database.tareaDao().insertar(tarea)
                lista.add(tarea)
            }
        }
            ) {
            Text("Añadir")
        }
    }
}

@Composable
fun filaDeTarea(tarea: TareaEntity, coroutineScope: CoroutineScope){
    var checked by remember { mutableStateOf(tarea.hecho) }

    Row {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
                tarea.hecho = checked
                coroutineScope.launch {
                    database.tareaDao().actualizar(tarea)
                }
            }
        )
        Text(text = tarea.name)
    }
}

@Composable
fun lista(listaTareas:List<TareaEntity>,coroutineScope: CoroutineScope) {
    LazyColumn  {
        items(listaTareas){ tarea ->
            filaDeTarea(tarea,coroutineScope)

        }
    }
}

@Composable
fun miApp(){
    val coroutineScope = rememberCoroutineScope()
    var listaTareas = remember { mutableStateListOf<TareaEntity>() }
    LaunchedEffect(Unit) {
        listaTareas.clear()
        listaTareas.addAll(database.tareaDao().getALl())
    }
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly) {
        nuevaTarea(coroutineScope, listaTareas)
        lista(listaTareas,coroutineScope)
    }

}

