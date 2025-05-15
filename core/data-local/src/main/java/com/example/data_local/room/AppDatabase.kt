package com.example.data_local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data_local.room.course.FavoriteCourseDao
import com.example.data_local.room.course.FavoriteCourseEntity

@Database(
    entities = [FavoriteCourseEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private const val database_name = "main_database"
        private val lock = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        database_name
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun favoriteCoursesDao(): FavoriteCourseDao
}