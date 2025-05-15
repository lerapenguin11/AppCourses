package com.example.domain.di

import com.example.domain.usecase.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.ChangeFavoriteStatusUseCaseImpl
import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.GetCoursesUseCaseImpl
import com.example.domain.usecase.GetFavoriteCoursesByIdUseCase
import com.example.domain.usecase.GetFavoriteCoursesByIdUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UseCaseModule {
    @Binds
    fun bindGetCoursesUseCase(useCase: GetCoursesUseCaseImpl): GetCoursesUseCase

    @Binds
    fun bindGetFavoriteCoursesByIdUseCase(useCase: GetFavoriteCoursesByIdUseCaseImpl): GetFavoriteCoursesByIdUseCase

    @Binds
    fun bindChangeFavoriteStatusUseCase(useCase: ChangeFavoriteStatusUseCaseImpl): ChangeFavoriteStatusUseCase
}