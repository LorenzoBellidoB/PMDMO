package es.iesnervion.ejemplonavegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.iesnervion.ejemplonavegacion.ui.theme.EjemploNavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "inicio",
                modifier = Modifier.fillMaxSize(),
            ) {
                composable("inicio") {
                    PantallaInicio(
                        navControllerInicio=navController,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                composable("perfil") {
                    PantallaPerfil(navControllerPerfil = navController,
                        modifier = Modifier.fillMaxHeight())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Play",
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
    )
}

@Composable
fun Imagen(imagen: Int) {
    Image(
        painter = painterResource(id = imagen),
        contentDescription = "Imagen",
        modifier = Modifier
            .width(250.dp)
            .height(250.dp)
    )
}

@Composable
fun PantallaPerfil(modifier: Modifier = Modifier, navControllerPerfil: NavHostController) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Estás en el perfil",
            modifier = modifier,
            fontSize = 20.sp,
        )
        Imagen(imagen = R.drawable.ic_launcher_foreground)
    }
    BarraNavegacion(navController = navControllerPerfil)
}

@Composable
fun PantallaInicio(modifier: Modifier = Modifier, navControllerInicio: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello Inicio!",
            modifier = modifier
        )
        Greeting(name = "Soy yo", modifier = modifier)
    }
    BarraNavegacion(navController = navControllerInicio)
}

@Composable
fun BarraNavegacion(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top
    ) {
        Button(onClick = { navController.navigate("inicio") }) {
            Text(text = "Inicio")
        }
        Button(onClick = { navController.navigate("perfil") }) {
            Text(text = "Perfil")
        }
    }
}