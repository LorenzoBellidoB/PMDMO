package com.example.apuestasroom.dal

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "sorteos")
data class SorteoEntity(
    @PrimaryKey(autoGenerate = true)
    val idSorteo: Long = 0,
    var numGanador1 : Int = 0,
    var numGanador2 : Int = 0
)
