package com.example.ejemploroom

import androidx.room.RoomDatabase

abstract class TareaDatabase: RoomDatabase() {

        abstract fun tareaDao(): TareaDao
}