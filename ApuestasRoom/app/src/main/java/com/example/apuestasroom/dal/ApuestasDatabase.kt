package com.example.apuestasroom.dal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JugadorEntity::class, SorteoEntity::class], version = 1)
abstract class ApuestasDatabase: RoomDatabase() {
    abstract fun jugadoresDao(): JugadoresDao
    abstract fun sorteosDao(): SorteosDao
}