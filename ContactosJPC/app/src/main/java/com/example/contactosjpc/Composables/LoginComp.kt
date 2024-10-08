package com.example.contactosjpc.Composables

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun SimpleLogin() {
    var text by rememberSaveable { mutableStateOf("Usuario") }
    var password by remember { mutableStateOf("") }
    row{
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Usuario") }
        )
    }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Button(onClick = {  }) {
        Text(text = "Inicia Sesion")
    }


}