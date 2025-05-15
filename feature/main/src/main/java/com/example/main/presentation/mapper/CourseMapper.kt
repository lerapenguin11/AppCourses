package com.example.main.presentation.mapper

import com.example.domain.model.Course
import com.example.model.CourseUI

fun Course.toCourseUI() = CourseUI(
    id = id,
    image = image,
    rate = rate,
    startDate = startDate,
    isFavorite = isFavorite,
    title = title,
    price = price,
    description = description,
)