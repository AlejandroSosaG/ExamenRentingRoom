package com.example.examen.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alquiler")
data class Alquiler(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "fechaEntrada")
    var fechaEntrada : Long,

    @ColumnInfo(name = "fechaSalida")
    var fechaSalida: Long,

    @ColumnInfo(name = "idCliente")
    var idCliente : Int,

    @ColumnInfo(name = "mensualidad")
    var mensualidad : Float,
)

