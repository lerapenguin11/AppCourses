package com.example.data.di

import com.example.data.repository.CourseRepositoryImpl
import com.example.domain.repository.CourseRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    fun bindCourseRepository(repository: CourseRepositoryImpl): CourseRepository
}