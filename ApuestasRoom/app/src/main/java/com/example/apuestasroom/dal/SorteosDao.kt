package com.example.apuestasroom.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SorteosDao {
    @Query("SELECT * FROM sorteos")
    suspend fun getAll(): List<SorteoEntity>

    @Query("SELECT * FROM sorteos WHERE idSorteo = :id")
    suspend fun getById(id: Long): SorteoEntity?

    @Insert
    suspend fun insert(sorteo: SorteoEntity): Long

    @Update
    suspend fun update(sorteo: SorteoEntity)

    @Query("DELETE FROM sorteos WHERE idSorteo = :id")
    suspend fun delete(id: Long)


}