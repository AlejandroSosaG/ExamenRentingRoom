package com.example.examen.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Alquiler :: class], version = 1)
abstract class AlquilerDatabase : RoomDatabase(){
    abstract fun alquilerDao() : AlquilerDao
}