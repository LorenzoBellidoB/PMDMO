package com.example.stonepapersscissors.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jugadores")
data class JugadorEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var luchasGanadas: Int = 0,
    var partidasGanadas: Int = 0,
    var partidasJugadas: Int = 0
)