package com.example.examen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.examen.db.Alquiler
import com.example.examen.db.AlquilerDao
import kotlinx.coroutines.runBlocking

/**
 * Función que muestra un listado de todas las habitaciones con la información de cada una.
 */
@Composable
fun ListaHabitaciones(navController: NavController, dao: AlquilerDao){
    val alquileres: List<Alquiler> = runBlocking { dao.mostrarAlquiler() }
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(1){
            for (alquiler in alquileres){
                Card (
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("Gestion/${alquiler}")
                        }
                ) {
                    Text(
                        text = alquiler.id.toString(),
                        fontSize = 20.sp
                    )
                    Text(
                        text = alquiler.fechaEntrada.toString(),
                        fontSize = 20.sp
                    )
                    Text(
                        text = alquiler.fechaSalida.toString(),
                        fontSize = 20.sp
                    )
                    Text(
                        text = alquiler.idCliente.toString(),
                        fontSize = 20.sp
                    )
                    Text(text = alquiler.mensualidad.toString(),
                        fontSize = 20.sp)
                }
            }
        }
    }
    // Barra de navegación con las diferentes pantallas.
    Row (verticalAlignment = Alignment.Bottom){
        Button(onClick = { navController.navigate("Configuracion") }) {
            Text(text = "Configuración básica")
        }
        Button(onClick = { navController.navigate("ListaHabitaciones")}) {
            Text(text = "Lista de habitaciones")
        }
    }
}