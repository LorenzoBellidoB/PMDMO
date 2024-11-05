package com.example.tareasroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.tareasroom.dal.TareasDatabase
import com.example.tareasroom.ui.theme.TareasRoomTheme
import com.example.tareasroom.ui.theme.views.miApp

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: TareasDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            applicationContext,
            TareasDatabase::class.java,
            "tareas-db"
        ).build()
        enableEdgeToEdge()
        setContent {
            TareasRoomTheme {
                miApp()
            }
        }
    }
}

