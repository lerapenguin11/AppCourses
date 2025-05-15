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

fun mapCourseUIWhitFavoriteCourses(course: CourseUI, idFavoriteCourses: List<Int>) = CourseUI(
    id = course.id,
    image = course.image,
    title = course.title,
    rate = course.rate,
    startDate = course.startDate,
    isFavorite = if (idFavoriteCourses.contains(course.id)) true else course.isFavorite,
    description = course.description,
    price = course.price,
    //publishDate = course.publishDate,
)