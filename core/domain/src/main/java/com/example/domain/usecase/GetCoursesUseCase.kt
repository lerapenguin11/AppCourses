package com.example.domain.usecase

import com.example.domain.model.Course
import com.example.domain.utils.ServerResult
import kotlinx.coroutines.flow.Flow

interface GetCoursesUseCase {
    suspend operator fun invoke(): Flow<ServerResult<List<Course>>>
}