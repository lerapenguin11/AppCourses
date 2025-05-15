package com.example.data_local.di

import android.app.Application
import com.example.data_local.room.AppDatabase
import com.example.data_local.room.course.FavoriteCourseDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): FavoriteCourseDao =
        AppDatabase.getInstance(context = application).favoriteCoursesDao()
}