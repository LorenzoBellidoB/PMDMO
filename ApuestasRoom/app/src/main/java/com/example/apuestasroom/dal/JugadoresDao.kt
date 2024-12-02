package com.example.apuestasroom.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface JugadoresDao {
    @Query("SELECT * FROM jugadores")
    suspend fun getAll(): List<JugadorEntity>

    @Query("SELECT * FROM jugadores WHERE id = :id")
    suspend fun getById(id: Long): JugadorEntity?

    @Insert
    suspend fun insert(jugador: JugadorEntity): Long

    @Update
    suspend fun update(jugador: JugadorEntity)

    @Query("DELETE FROM jugadores WHERE id = :id")
    suspend fun delete(id: Long)


}