package co.edu.udea.compumovil.gr06_20211.lab2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "POI")
data class Lugares (
        val nombre: String = "",
        val informacion: String = "",
        val ubicacion: String = "",
        val temperatura: String = "",
        @PrimaryKey(autoGenerate = true)
        val idLugares: Int=0

        )