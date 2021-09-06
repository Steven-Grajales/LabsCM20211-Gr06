package co.edu.udea.compumovil.gr06_20211.lab2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.edu.udea.compumovil.gr06_20211.lab2.domain.LugaresDao
import co.edu.udea.compumovil.gr06_20211.lab2.domain.UserDao
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares
import co.edu.udea.compumovil.gr06_20211.lab2.model.User_Entity_Activity

@Database(entities = [Lugares::class, User_Entity_Activity::class], version=3)
abstract class DataBase: RoomDatabase() {

    abstract fun lugares(): LugaresDao

    abstract fun UserDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}