package com.example.data_local.room.course

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteCourseEntity(
    @PrimaryKey
    val courseId: Int
)
