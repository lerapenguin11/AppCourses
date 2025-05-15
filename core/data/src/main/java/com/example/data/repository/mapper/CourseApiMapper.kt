package com.example.data.repository.mapper

import com.example.data_remote.api.model.CourseDto
import com.example.domain.model.Course

fun CourseDto.mapToDomain() = Course(
    id = id,
    image = "https://avatars.mds.yandex.net/i?id=88e6034a199f7a12d96583407efae638df366d9a-5177970-images-thumbs&n=13",
    title = title,
    rate = rate,
    startDate = startDate,
    isFavorite = hasLike,
    description = text,
    price = price,
    publishDate = publishDate,
)

fun mapCourseWhitFavoriteCourses(course: Course, idFavoriteCourses: List<Int>) = Course(
    id = course.id,
    image = course.image,
    title = course.title,
    rate = course.rate,
    startDate = course.startDate,
    isFavorite = if (idFavoriteCourses.contains(course.id)) true else course.isFavorite,
    description = course.description,
    price = course.price,
    publishDate = course.publishDate,
)