package com.example.contactosjpc.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactosjpc.R

@Preview
@Composable
fun SimpleLogin() {
    var text by rememberSaveable { mutableStateOf("Usuario") }
    var password by remember { mutableStateOf("") }




    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.kfc),
            contentDescription = "Foto contacto",
            Modifier.height(100.dp)
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = text,
            onValueChange = { text = it },
            label = { Text("Usuario") }
        )




        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )



        OutlinedButton(
            modifier = Modifier.padding(10.dp),
            onClick = {

            }
        ) {

            Text(text = "Inicia Sesion", color = Color.Black)
        }
    }

}