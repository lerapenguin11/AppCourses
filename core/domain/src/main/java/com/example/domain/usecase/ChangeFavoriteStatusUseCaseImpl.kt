package com.example.domain.usecase

import com.example.domain.repository.CourseRepository
import javax.inject.Inject

internal class ChangeFavoriteStatusUseCaseImpl @Inject constructor(private val repository: CourseRepository) :
    ChangeFavoriteStatusUseCase {

    override suspend fun invoke(courseId: Int) {
        repository.changeFavoriteStatus(courseId)
    }
}