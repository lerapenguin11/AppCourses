package com.example.domain.repository

import com.example.domain.model.Course
import com.example.domain.utils.ServerResult
import kotlinx.coroutines.flow.Flow

interface CourseRepository {

    fun getCourses(): Flow<ServerResult<List<Course>>>
}