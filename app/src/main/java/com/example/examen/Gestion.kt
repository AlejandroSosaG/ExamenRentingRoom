package com.example.examen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.examen.db.Alquiler
import com.example.examen.db.AlquilerDao
import kotlinx.coroutines.runBlocking

/**
 * Función que muestra el estado de la habitación seleccionada y un botón según si la habitación está libre u ocupada.
 * Si la habitación está ocupada la deja libre y si está libre la ocupa.
 */
@Composable
fun Gestion(navController: NavController, dao: AlquilerDao, alquiler: Alquiler){
    Column {
        Text(text = "Estado de la habitación: ")
        if (1==1){
            Text(text = "Ocupada")
            Button(onClick = {
                alquiler.fechaEntrada = 0
                alquiler.fechaSalida = buscarFechaSuperior(dao).toLong()
                runBlocking { dao.actualizarAlquiler(alquiler) }
            }) {
                Text(text = "CheckOut")
            }
        }else{
            Text(text = "Libre")
            Button(onClick = {
                alquiler.fechaSalida = 0
                alquiler.fechaEntrada = buscarFechaSuperior(dao).toLong()
                runBlocking { dao.actualizarAlquiler(alquiler) }
            }) {
                Text(text = "CheckIn")
            }
        }
    }
    Row (verticalAlignment = Alignment.Bottom){
        Button(onClick = { navController.navigate("Configuracion") }) {
            Text(text = "Configuración básica")
        }
        Button(onClick = { navController.navigate("ListaHabitaciones") }) {
            Text(text = "Lista de habitaciones")
        }
        Button(onClick = { navController.navigate("Gestion")}) {
            Text(text = "Gestión del alquiler")
        }
    }
}

/**
 * Función que devuelve la última fecha introducida.
 */
fun buscarFechaSuperior(dao: AlquilerDao) : Double {
    var fecha = 0.0
    var alquileres : MutableList<Alquiler>
    runBlocking { alquileres = dao.mostrarAlquiler()}
    for (alquiler in alquileres){
        if (fecha < alquiler.fechaEntrada){
            fecha = alquiler.fechaEntrada.toDouble()
        }
        if (fecha < alquiler.fechaSalida){
            fecha = alquiler.fechaSalida.toDouble()
        }
    }
    return fecha
}