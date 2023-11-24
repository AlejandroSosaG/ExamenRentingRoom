package com.example.examen

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen.db.AlquilerViewModel
import com.example.examen.db.Configuracion
import com.example.examen.db.ConfiguracionViewModel
import com.example.examen.ui.theme.ExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenTheme {
                val navController = rememberNavController() // Controlador que usamos para navegar entre pantallas.
                val contexto = LocalContext.current // Contexto actual de la aplicación
                val alquilerDao = AlquilerViewModel(contexto.applicationContext as Application).database
                val configuracionDao = ConfiguracionViewModel(contexto.applicationContext as Application).database
                // NavHost con las difeerentes pantallas que utilizamos.
                NavHost(navController = navController, startDestination = "Configuracion"){
                    composable("Configuracion"){
                        Configuracion(navController = navController, configuracionDao.configuracionDao())
                    }
                    composable("ListaHabitaciones"){
                        ListaHabitaciones(navController = navController, alquilerDao.alquilerDao())
                    }
                    composable("Gestion"){
                        //Gestion(navController = navController, alquilerDao.alquilerDao())
                    }
                }
            }
        }
    }
}