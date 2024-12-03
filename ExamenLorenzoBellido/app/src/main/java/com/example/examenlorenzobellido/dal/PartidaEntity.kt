package com.example.examenlorenzobellido.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidas")
data class PartidaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val jugador1: Int = 0,
    val jugador2: Int = 0,
    val resultado: Int = 0,
    val fecha: String = "03/12/2024"
)
