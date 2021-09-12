package co.edu.udea.compumovil.gr06_20211.lab2.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "POI")
data class Lugares (
        val nombre: String = "",
        val imagen: String = "",
        val informacion: String = "",
        val ubicacion: String = "",
        val temperatura: String = "",
        @PrimaryKey(autoGenerate = true)
        val idLugares: Int=0

        ): Parcelable