package com.example.examen.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Configuracion")
data class Configuracion(
    @PrimaryKey
    @ColumnInfo(name = "numHabitaciones")
    var numHabitaciones : Int,
    @ColumnInfo(name = "precio")
    var precio : Float,
)