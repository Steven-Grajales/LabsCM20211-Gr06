package co.edu.udea.compumovil.gr06_20211.lab2.domain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares
import co.edu.udea.compumovil.gr06_20211.lab2.model.User_Entity_Activity

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE user = :user")
    fun getUser(user: String): LiveData<User_Entity_Activity>
}