package com.example.examenlorenzobellido.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PartidasDao {
    @Query("SELECT * FROM partidas")
    suspend fun obtenerPartidas(): List<PartidaEntity>


    @Query("SELECT Count(id) FROM partidas WHERE jugador1 = :id OR jugador2 = :id")
    suspend fun obtenerPartidasPorJugador(id: Int): Int

    @Query("SELECT * FROM partidas WHERE jugador1 = :id OR jugador2 = :id")
    suspend fun obtenerDatosPartidasPorJugador(id: Int): List<PartidaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(partida: PartidaEntity)

    @Update
    suspend fun actualizar(partida: PartidaEntity)

}