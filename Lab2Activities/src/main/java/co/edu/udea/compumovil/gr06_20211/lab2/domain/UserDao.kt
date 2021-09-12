package co.edu.udea.compumovil.gr06_20211.lab2.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares
import co.edu.udea.compumovil.gr06_20211.lab2.model.User_Entity_Activity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE user = :user")
    fun getUser(user: String): LiveData<User_Entity_Activity>

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User_Entity_Activity>>

    @Insert
    fun insert(user: User_Entity_Activity)

    @Update
    fun update(user: User_Entity_Activity)

    @Delete
    fun delete(user: User_Entity_Activity)

}