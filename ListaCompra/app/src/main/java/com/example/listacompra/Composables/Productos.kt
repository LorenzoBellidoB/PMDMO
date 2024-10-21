package com.example.listacompra.Composables

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listacompra.Productos.Producto
import com.example.listacompra.R


@Composable
fun ListaProductos(): List<Producto> {
    return listOf(
        Producto("Leche", 5.0,  painterResource(id = R.drawable.leche)),
        Producto("Huevos", 4.0, painterResource(id = R.drawable.huevos)),
        Producto("Colacao", 2.5,  painterResource(id = R.drawable.cereales)),
        Producto("Pan", 0.8,  painterResource(id = R.drawable.pan)),
        Producto("Tomate", 1.2,  painterResource(id = R.drawable.tomate))
    )
}

@Composable
fun Carrito(navController: NavController,contador: Int){
var precioTotal by remember { mutableDoubleStateOf(0.0) }

    Row(
        modifier = Modifier.fillMaxSize().padding(top = 20.dp, end = 10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.End
        ) {

        Image(painter = painterResource(R.drawable.carrito),
            contentDescription = "Carrito",
            modifier = Modifier.size(70.dp).clickable {  navController.navigate("carrito/${contador}") })
    }


}

@Composable
fun ProductoCard(producto : Producto){
Column(Modifier.fillMaxSize()) {
    Image(
        painter = producto.painter,
        contentDescription = "Imagen de " + producto.nombre
    )
    Modifier.width(40.dp).height(40.dp).size(40.dp)

    Text(
        producto.nombre,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )

    Text(
        producto.precio.toString(),
        fontSize = 16.sp
    )

}
}

@Composable
fun Cantidad(producto: Producto): Int{
    var contador: Int = 0
    Row (Modifier.fillMaxWidth()) {
        Button(onClick = { producto.cantidad += 1
        contador += 1}) {
            Text("+")
        }
        Button(enabled = producto.cantidad > 0,
            onClick = {if(producto.cantidad > 0){

                producto.cantidad -= 1
                contador -= 1
        }}) {
            Text("-")
        }

        Text(text = producto.cantidad.toString(),
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            fontSize = 20.sp)

        }

    return contador
}

@Composable

fun VistaProductos(navControllerProductos: NavController) {
    val productos = ListaProductos()
    var contador by remember { mutableIntStateOf(0) }




    LazyColumn(Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center)  {
        items(productos){ producto ->
            ProductoCard(producto)
            contador += Cantidad(producto)
        }



    }
    Carrito(navControllerProductos,contador)
}