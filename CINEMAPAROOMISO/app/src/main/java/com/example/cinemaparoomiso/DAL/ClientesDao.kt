package com.example.cinemaparoomiso.DAL

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ClientesDao {
    @Query("SELECT * FROM clientes")
    suspend fun obtenerClientes(): List<ClienteEntity>

    @Query("SELECT * FROM clientes WHERE id = :id")
    suspend fun obtenerPorId(id: Long): ClienteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarCliente(cliente: ClienteEntity)

    @Update
    suspend fun actualizarCliente(cliente: ClienteEntity)

    @Delete
    suspend fun borrarCliente(cliente: ClienteEntity)


}