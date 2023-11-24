package com.example.examen.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface AlquilerDao {
    @Query("SELECT * FROM Alquiler")
    suspend fun mostrarAlquiler() : MutableList<Alquiler>

    @Update
    suspend fun actualizarAlquiler(alquiler: Alquiler)
}