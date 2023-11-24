package com.example.examen.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Configuracion :: class], version = 1)
abstract class ConfiguracionDatabase : RoomDatabase(){
    abstract fun configuracionDao() : ConfiguracionDao
}