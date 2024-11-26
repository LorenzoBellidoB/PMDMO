package com.example.cinemaparoomiso.DAL

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConfiguracionesDao {
    @Query("SELECT * FROM configuraciones")
    suspend fun obtenerConfiguraciones(): List<ConfiguracionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarConfiguracion(configuracion: ConfiguracionEntity)

    @Update
    suspend fun actualizarConfiguracion(configuracion: ConfiguracionEntity)

    @Delete
    suspend fun borrarConfiguracion(configuracion: ConfiguracionEntity)

}