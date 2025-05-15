package com.example.domain.usecase

interface ChangeFavoriteStatusUseCase {

    suspend operator fun invoke(courseId: Int)
}