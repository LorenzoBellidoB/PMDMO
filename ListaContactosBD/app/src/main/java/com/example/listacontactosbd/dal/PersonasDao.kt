package com.example.listacontactosbd.dal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PersonasDao {
    @Query("SELECT * FROM personas")
    suspend fun getAll(): List<PersonaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertar(persona: PersonaEntity)

    @Update
    suspend fun actualizar(persona: PersonaEntity)

    @Delete
    suspend fun eliminar(persona: PersonaEntity)

    @Query("DELETE FROM personas")
    suspend fun deleteAll()
}