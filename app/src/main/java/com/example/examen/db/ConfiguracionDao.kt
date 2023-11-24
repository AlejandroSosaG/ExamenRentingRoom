package com.example.examen.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConfiguracionDao {
    @Query("SELECT * FROM Configuracion")
    suspend fun mostrarConfiguracion() : Configuracion

    @Update
    suspend fun actualizarConfiguracion(configuracion: Configuracion)
}