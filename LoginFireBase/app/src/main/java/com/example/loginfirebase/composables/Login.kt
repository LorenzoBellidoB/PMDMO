package com.example.loginfirebase.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavHostController
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


@Composable
fun login(navHostController: NavHostController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            TextField(value = email
                , onValueChange = {email = it}
                , label = { Text(text = "Email")}
            )
            TextField(value = password
                , onValueChange = {password = it}
                , label = { Text(text = "Contraseña")}
                , visualTransformation = PasswordVisualTransformation()
            )
            Button(onClick =
            {
                val mAuth = FirebaseAuth.getInstance()
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task: Task<AuthResult?> ->
                        if (task.isSuccessful) {
                            navHostController.navigate("inicio")
                        } else {
                            navHostController.navigate("error")
                        }
                    }

            },enabled = email.isNotEmpty() && password.isNotEmpty()
            ) {
                Text(text = "Iniciar Sesión")
            }
    }
}