package com.example.listacontactosbd.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personas")
data class PersonaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var nombre: String = "",
    var telefono: String = "",
    var sexo: Int = 0
)
