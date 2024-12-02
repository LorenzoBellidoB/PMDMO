package com.example.apuestasroom.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface JugadoresDao {
    @Query("SELECT * FROM jugadores")
    suspend fun getAll(): List<JugadorEntity>

    @Query("SELECT * FROM jugadores WHERE id = :id")
    suspend fun getById(id: Long): JugadorEntity?

    @Query("SELECT * FROM jugadores WHERE numElegido1 = :numGanador1 AND numElegido2 = :numGanador2")
    suspend fun obtenerGanadores(numGanador1: Int, numGanador2: Int): List<JugadorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(jugador: JugadorEntity): Long

    @Update
    suspend fun update(jugador: JugadorEntity)

    @Query("DELETE FROM jugadores WHERE id = :id")
    suspend fun delete(id: Long)


}