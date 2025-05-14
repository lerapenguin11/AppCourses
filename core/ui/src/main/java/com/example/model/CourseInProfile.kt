package com.example.model

data class CourseInProfileUI(
    val id: Int,
    val image: String?,
    val rate: String,
    val startDate: String,
    val isFavorite: Boolean,
    val title: String,
    val progress: Int,
    val numberLessons: Int,
    val completedLessons: Int,
)
