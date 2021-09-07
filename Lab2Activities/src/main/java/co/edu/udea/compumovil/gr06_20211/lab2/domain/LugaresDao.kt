package co.edu.udea.compumovil.gr06_20211.lab2.domain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares

@Dao
interface LugaresDao {

    @Query("SELECT * FROM POI")
    fun getAll(): LiveData<List<Lugares>>
}