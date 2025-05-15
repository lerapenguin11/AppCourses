package com.example.domain.usecase

import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import com.example.domain.utils.ServerResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetCoursesUseCaseImpl @Inject constructor(private val repository: CourseRepository) :
    GetCoursesUseCase {
    override fun invoke(): Flow<ServerResult<List<Course>>> {
        return repository.getCourses()
    }
}