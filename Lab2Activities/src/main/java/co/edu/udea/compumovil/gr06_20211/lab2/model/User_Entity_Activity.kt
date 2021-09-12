package co.edu.udea.compumovil.gr06_20211.lab2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User_Entity_Activity (
    val user:  String,
    val pass:  String,
    val email: String,

    @PrimaryKey(autoGenerate = true) val idUser: Int=0

)