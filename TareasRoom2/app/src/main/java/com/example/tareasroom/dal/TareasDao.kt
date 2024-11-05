package com.example.tareasroom.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TareasDao {
    @Query("SELECT * FROM tareas")
    suspend fun  getALl():List<TareaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(tarea:TareaEntity):Long

    @Update
    suspend fun actualizar(tarea: TareaEntity)
}