package com.example.cinemaparoomiso.DAL

import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configuraciones")
data class ConfiguracionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var numSalas: Int = 0,
    var numAsientos: Int = 0,
    var precioPalomitas: Float = 0.0f

)
