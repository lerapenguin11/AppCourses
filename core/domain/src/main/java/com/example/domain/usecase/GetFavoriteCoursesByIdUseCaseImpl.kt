package com.example.domain.usecase

import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetFavoriteCoursesByIdUseCaseImpl @Inject constructor(private val repository: CourseRepository) :
    GetFavoriteCoursesByIdUseCase {
    override fun invoke(): Flow<List<Int>> {
        return repository.getFavoriteCoursesById()
    }
}