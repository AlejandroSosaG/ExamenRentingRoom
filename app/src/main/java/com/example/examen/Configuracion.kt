package com.example.examen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.examen.db.Configuracion
import com.example.examen.db.ConfiguracionDao
import kotlinx.coroutines.runBlocking

/**
 * Función que muestra la información de la configuración básica de la App.
 */
@Composable
fun Configuracion(navController: NavController, dao: ConfiguracionDao){
    val configuracion: Configuracion = runBlocking { dao.mostrarConfiguracion() }
    // Columna con la info que debería aparecer en el centro pero no se alinea.
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Número de habitaciones")
        Text(text = configuracion.numHabitaciones.toString())
        Text(text = "Precio del alquiler mensual de la habitación")
        Text(text = configuracion.precio.toString())

    }
    // Barra de navegación con las distintas pantallas.
    // Debería aparecer en la parte inferior pero no lo hace.
    Row (verticalAlignment = Alignment.Bottom){
        Button(onClick = { navController.navigate("Configuracion") }) {
            Text(text = "Configuración básica")
        }
        Button(onClick = { navController.navigate("ListaHabitaciones") }) {
            Text(text = "Lista de habitaciones")
        }
    }
}