package com.example.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetFavoriteCoursesByIdUseCase {
    operator fun invoke(): Flow<List<Int>>
}