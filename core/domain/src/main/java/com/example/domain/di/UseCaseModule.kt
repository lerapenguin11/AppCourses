package com.example.domain.di

import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.GetCoursesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UseCaseModule {
    @Binds
    fun bindGetCoursesUseCase(useCase: GetCoursesUseCaseImpl): GetCoursesUseCase
}