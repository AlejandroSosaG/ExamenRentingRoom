package com.example.examen.db

import kotlinx.coroutines.runBlocking

class CRUDAlquiler {
    companion object{
        /**
         * Esta función nos permite actualizar los datos del alquiler de una habitación.
         */
        fun actualizarAlquiler(id : Long, fechaEntrada : Long, fechaSalida: Long, idCliente : Int, mensualidad : Float, dao : AlquilerDao){
            val alquiler = Alquiler(id, fechaEntrada, fechaSalida, idCliente, mensualidad)
            runBlocking { dao.actualizarAlquiler(alquiler) }
        }

    }
}