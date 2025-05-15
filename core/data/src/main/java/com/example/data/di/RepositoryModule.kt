package com.example.data.di

import com.example.data.repository.CourseRepositoryImpl
import com.example.domain.repository.CourseRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindCourseRepository(repository: CourseRepositoryImpl): CourseRepository
}