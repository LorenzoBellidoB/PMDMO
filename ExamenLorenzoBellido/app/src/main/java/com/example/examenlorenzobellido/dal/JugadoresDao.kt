package com.example.examenlorenzobellido.dal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface JugadoresDao {
    @Query("SELECT * FROM jugadores")
    fun obtenerJugadores(): List<JugadorEntity>

    @Query("SELECT * FROM jugadores WHERE id = :id")
    suspend fun obtenerJugadorPorId(id: Int): JugadorEntity?

    @Query("SELECT nombre FROM jugadores WHERE id = :id")
    suspend fun obtenerNombre(id: Int): String

    @Query("SELECT * FROM jugadores ORDER BY puntos DESC")
    suspend fun obtenerJugadorOrdenados(): List<JugadorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(jugador: JugadorEntity)

    @Update
    suspend fun actualizar(jugador: JugadorEntity)

    @Delete
    suspend fun eliminar(jugador: JugadorEntity)

}