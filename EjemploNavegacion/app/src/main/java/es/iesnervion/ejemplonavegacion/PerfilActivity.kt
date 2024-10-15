package es.iesnervion.ejemplonavegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

class PerfilActivity: ComponentActivity() {
    @Composable
    fun PantallaPerfil(modifier: Modifier = Modifier, navControllerPerfil: NavHostController) {
        Text(
            text = "Hello Perfil!",
            modifier = modifier
        )
    }
}