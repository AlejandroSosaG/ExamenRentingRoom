package com.example.examen.db

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Room

class ConfiguracionViewModel(application: Application) : ViewModel() {
    val database: ConfiguracionDatabase by lazy {
        Room.databaseBuilder(
            application,
            ConfiguracionDatabase::class.java,
            "Configuracion"
        ).build()
    }
}