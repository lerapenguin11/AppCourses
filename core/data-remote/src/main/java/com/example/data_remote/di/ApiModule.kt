package com.example.data_remote.di

import com.example.data_remote.api.CourseApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal object ApiModule {
    @Provides
    fun provideCourseApi(retrofit: Retrofit): CourseApi = retrofit.create(CourseApi::class.java)
}