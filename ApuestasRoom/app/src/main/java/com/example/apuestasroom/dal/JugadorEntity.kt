package com.example.apuestasroom.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jugadores")
data class JugadorEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var nombre: String = "",
    var numElegido1: Int = 0,
    var numElegido2: Int = 0
)