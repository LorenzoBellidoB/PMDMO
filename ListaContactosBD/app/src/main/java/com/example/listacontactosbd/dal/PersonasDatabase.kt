package com.example.listacontactosbd.dal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonaEntity::class], version = 1)
abstract class PersonasDatabase: RoomDatabase() {
    abstract fun personaDao(): PersonasDao
}