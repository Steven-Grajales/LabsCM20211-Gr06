package co.edu.udea.compumovil.gr06_20211.lab2.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares
import co.edu.udea.compumovil.gr06_20211.lab2.model.User_Entity_Activity

@Dao
interface LugaresDao {

    @Query("SELECT * FROM POI")
    fun getAll(): LiveData<List<Lugares>>

    @Insert
    fun insert(lugares: Lugares)

    @Update
    fun update(lugares: Lugares)

    @Delete
    fun delete(lugares: Lugares)
}