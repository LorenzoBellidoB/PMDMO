package com.example.ejemploroom

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface TareaDao {
    @Query("SELECT * FROM tareas")
    suspend fun getAll():List<TareaEntity>

    @Query("SELECT * FROM tareas WHERE id = :id")
    suspend fun findById(id: Int): TareaEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tasks: List<TareaEntity>): Long

    @Update
    suspend fun update(tarea: TareaEntity)

    @Delete
    suspend fun delete(tarea: TareaEntity)
}