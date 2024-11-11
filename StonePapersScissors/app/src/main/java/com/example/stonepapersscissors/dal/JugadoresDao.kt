package com.example.stonepapersscissors.dal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface JugadoresDao {
    @Query("SELECT * FROM jugadores")
    suspend fun getAll(): List<JugadorEntity>

    @Query("SELECT * FROM jugadores WHERE id = :playerId")
    suspend fun getJugadorById(playerId: Int): JugadorEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(jugador: JugadorEntity)

    @Update
    suspend fun actualizar(jugador: JugadorEntity)

    @Delete
    suspend fun eliminar(jugador: JugadorEntity)

    @Query("DELETE FROM jugadores") // Assuming 'jugadores' is your table name
    suspend fun deleteAll()
}