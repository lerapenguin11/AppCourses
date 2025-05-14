package com.example.domain.model

data class Course(
    val id: Int,
    val image: String?,
    val rate: String,
    val startDate: String,
    val isFavorite: Boolean,
    val title: String,
    val price: String,
    val description: String,
)
