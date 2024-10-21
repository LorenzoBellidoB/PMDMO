package com.example.calculadorajpc.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.calculadorajpc.R

@Composable
fun VistaResultado(navControllerResultado: NavController, resultado: String?) {
    Column() {

        Image(
            painter = painterResource(R.drawable.baseline_west_24),
            contentDescription = "Pa Tras" ,
            Modifier.clickable {navControllerResultado.popBackStack() }.padding(top = 30.dp).size(30.dp)
        )


        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text("Resultado: ${resultado}",
                fontSize = 24.sp)

        }



    }
}