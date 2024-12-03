package com.example.examenlorenzobellido.dal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JugadorEntity::class, PartidaEntity::class], version = 1)
abstract class AjedrezDatabase: RoomDatabase() {
    abstract fun jugadoresDao(): JugadoresDao
    abstract fun partidasDao(): PartidasDao
}