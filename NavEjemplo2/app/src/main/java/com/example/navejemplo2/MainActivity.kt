package com.example.navejemplo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navejemplo2.ui.theme.NavEjemplo2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            NavEjemplo2Theme {

                val navController: NavHostController = rememberNavController()
                NavHost(navController = navController, startDestination = "1") {
                    composable("1") { Pantalla1(navController1 = navController) }
                    composable("2") { Pantalla2(navController2 = navController) }
                    composable("3") { Pantalla3(navController3 = navController) }
                    composable("4") { Pantalla4(navController4 = navController) }


                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    fun GreetingPreview() {
        NavEjemplo2Theme {
            Greeting("Android")
        }
    }

    @Composable
    fun Imagen(imagen: Int, mostrar: Boolean, onClick: () -> Unit) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = "Foto 1",
            modifier = Modifier
                .padding(15.dp)
                .clickable { onClick() }
        )
    }

    @Composable
    fun Pantalla1(modifier: Modifier = Modifier, navController1: NavHostController) {
        var mostrar by remember { mutableStateOf(false) }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Imagen(imagen = R.drawable.spider_man, mostrar = !mostrar) {
                mostrar = !mostrar
            }
            if (mostrar) {
                Text(
                    text = "Creación: Spider-Man fue creado por Stan Lee y Steve Ditko, y apareció por primera vez en el cómic Amazing Fantasy #15 en agosto de 1962.\n" +
                            "Poderes: Sus poderes incluyen fuerza, velocidad, agilidad y reflejos sobrehumanos, así como la capacidad de adherirse a las superficies y un sentido arácnido que le advierte del peligro.",
                    modifier = modifier.padding(20.dp),
                    fontSize = 20.sp
                )
            }
        }
        BarraNavegacion(navController = navController1, "1")
    }

    @Composable
    fun Pantalla2(modifier: Modifier = Modifier, navController2: NavHostController) {
        var mostrar by remember { mutableStateOf(false) }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Imagen(imagen = R.drawable.megaman, mostrar = !mostrar) {
                mostrar = !mostrar
            }
            if (mostrar) {
                Text(
                    text = "Creación: Mega Man fue creado por Akira Kitamura y apareció por primera vez en el juego Mega Man para la Nintendo Entertainment System (NES) en 19871.",
                    modifier = modifier.padding(20.dp),
                    fontSize = 20.sp
                )
            }
        }
        BarraNavegacion(navController = navController2, "2")
    }

    @Composable
    fun Pantalla3(modifier: Modifier = Modifier, navController3: NavHostController) {
        var mostrar by remember { mutableStateOf(false) }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Imagen(imagen = R.drawable.lobo, mostrar = !mostrar) {
                mostrar = !mostrar
            }
            if (mostrar) {
                Text(
                    text = "Creación: Lobo fue creado por Roger Slifer y Keith Giffen, y apareció por primera vez en Omega Men #3 en junio de 19831.\n" +
                            "Planeta de Origen: Es originario del planeta Czarnia, un lugar utópico que él mismo destruyó, convirtiéndose en el último de su especie1.",
                    modifier = modifier.padding(20.dp),
                    fontSize = 20.sp
                )
            }
        }
        BarraNavegacion(navController = navController3, "3")
    }

    @Composable
    fun Pantalla4(modifier: Modifier = Modifier, navController4: NavHostController) {
        var mostrar by remember { mutableStateOf(false) }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Imagen(imagen = R.drawable.batman, mostrar = !mostrar) {
                mostrar = !mostrar
            }
            if (mostrar) {
                Text(
                    text = "Creación: Batman fue creado por Bob Kane y Bill Finger, y apareció por primera vez en Detective Comics #27 en mayo de 19391.\n" +
                            "Identidad Secreta: Su verdadero nombre es Bruce Wayne, un millonario de Gotham City2.",
                    modifier = modifier.padding(20.dp),
                    fontSize = 20.sp
                )
            }
        }
        BarraNavegacion(navController = navController4, "4")
    }


    @Composable
    fun BarraNavegacion(navController: NavHostController, pantallaActual: String) {
        Row(
            modifier = Modifier.fillMaxSize().
            padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(enabled = pantallaActual != "1" ,
                onClick = { navController.navigate("1") }) {
                Text(text = "1")
            }
            Button(enabled = pantallaActual != "2",
                onClick = { navController.navigate("2") }) {
                Text(text = "2")
            }
            Button(enabled = pantallaActual != "3",
                onClick = { navController.navigate("3") }) {
                Text(text = "3")
            }
            Button(enabled = pantallaActual != "4",
                onClick = { navController.navigate("4") }) {
                Text(text = "4")
            }
        }
    }
}




