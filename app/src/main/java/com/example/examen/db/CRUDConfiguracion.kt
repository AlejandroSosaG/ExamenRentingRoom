package com.example.examen.db

import kotlinx.coroutines.runBlocking

class CRUDConfiguracion {
    companion object{
        /**
         * Esta función nos permite actualizar los datos de la configuración básica de la App.
         */
        fun actualizarConfiguracion(numConfiguracion: Int, precio : Float, dao : ConfiguracionDao){
            val configuracion = Configuracion(numConfiguracion, precio)
            runBlocking { dao.actualizarConfiguracion(configuracion)}
        }
    }
}