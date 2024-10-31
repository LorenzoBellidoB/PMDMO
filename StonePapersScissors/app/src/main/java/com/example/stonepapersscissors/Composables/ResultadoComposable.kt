package com.example.stonepapersscissors.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stonepapersscissors.R

@Composable
fun Ganador(navController: NavHostController, string: String?) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Fondo())
    ) {
        Row(
            Modifier
                .padding(20.dp)
                .align(Alignment.TopStart),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_west_24),
                contentDescription = "Atras",
                Modifier
                    .padding(10.dp)
                    .width(30.dp)
                    .height(30.dp)
                    .clickable {
                        navController.navigate("inicio")
                    }
            )
        }

        Box(
            Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (string != null) {
                Text(
                    text = "Gana $string",
                    fontSize = 30.sp,
                    color = Color(80,20,35),
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text("Error")
            }
        }
    }
}
