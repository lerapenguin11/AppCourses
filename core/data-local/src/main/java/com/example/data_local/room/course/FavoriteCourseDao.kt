package com.example.data_local.room.course

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteCourses(favoriteCoursesDbModel: FavoriteCourseEntity)

    @Query("SELECT COUNT(*) > 0 FROM FavoriteCourseEntity WHERE courseId = :courseId")
    fun isCourseFavorite(courseId: Int): Flow<Boolean>

    @Query("SELECT * FROM FavoriteCourseEntity")
    fun getFavoriteCoursesList(): Flow<List<FavoriteCourseEntity>>

    @Query("DELETE FROM FavoriteCourseEntity WHERE courseId=:courseId")
    suspend fun deleteFromFavorites(courseId: Int)
}