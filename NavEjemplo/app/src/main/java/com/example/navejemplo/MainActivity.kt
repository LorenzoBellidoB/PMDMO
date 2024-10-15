package com.example.navejemplo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navejemplo.ui.theme.NavEjemploTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavEjemploTheme {
                NavHost(
                    navController = navController,
                    startDestination = "otra"
                ) {
                    composable("otra") { OtraPantalla(navController) }
                    composable("login") { GreetingPreview() }
                    /* .Gráfico de navegación. */
                }

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
fun OtraPantalla(navController: NavController, modifier: Modifier = Modifier){
    Text(
        text = "Estoy en otra pantalla",
        modifier = modifier
    )
    Button(
        onClick = {
            navController.navigate("login")
        }
    ){
        Text(text = "Volver")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavEjemploTheme {
        Greeting("Android")
    }
}