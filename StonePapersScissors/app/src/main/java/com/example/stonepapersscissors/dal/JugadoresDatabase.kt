package com.example.stonepapersscissors.dal

import androidx.room.Database
import androidx.room.RoomDatabase

// Clase abstracta que extiende de RoomDatabase
@Database(entities = [JugadorEntity::class], version = 1)
abstract class JugadoresDatabase: RoomDatabase() {
    abstract fun jugadorDao(): JugadoresDao
}
