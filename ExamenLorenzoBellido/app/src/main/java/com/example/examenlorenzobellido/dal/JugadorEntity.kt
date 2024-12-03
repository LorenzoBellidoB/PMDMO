package com.example.examenlorenzobellido.dal

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "jugadores")
data class JugadorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String = "",
    val puntos: Int = 0,
    val fecha: String = "03/12/2024",
)
