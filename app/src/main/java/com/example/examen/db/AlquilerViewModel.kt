package com.example.examen.db

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Room

class AlquilerViewModel(application: Application) : ViewModel() {
    val database: AlquilerDatabase by lazy {
        Room.databaseBuilder(
            application,
            AlquilerDatabase::class.java,
            "Alquiler"
        ).build()
    }
}