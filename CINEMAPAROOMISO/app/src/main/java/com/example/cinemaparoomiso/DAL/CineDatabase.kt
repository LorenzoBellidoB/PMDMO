package com.example.cinemaparoomiso.DAL

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ClienteEntity::class, ConfiguracionEntity::class], version = 1)
abstract class CineDatabase: RoomDatabase() {

    abstract fun clienteDao(): ClientesDao

    abstract fun configuracionDao(): ConfiguracionesDao
}