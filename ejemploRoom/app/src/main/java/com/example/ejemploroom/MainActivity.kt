package com.example.ejemploroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.ejemploroom.ui.theme.EjemploRoomTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val room: TareaDatabase = Room
            .databaseBuilder(this, TareaDatabase::class.java, "tareas")
            .build()


        runBlocking {
            launch{
                val tasks = room.tareaDao().getAll()
            }
        }

        enableEdgeToEdge()
        setContent {
            EjemploRoomTheme {

            }
        }
    }
}

