package com.example.data_local.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.data_local.room.AppDatabase
import com.example.data_local.room.course.FavoriteCourseDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal interface RoomModule {

    companion object {
        @Provides
        @Singleton
        fun provideAppDatabase(application: Context): AppDatabase {
            return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                "main_database"
            ).build()
        }

        @Singleton
        @Provides
        fun provideFavoriteCourseDao(appDatabase: AppDatabase): FavoriteCourseDao {
            return appDatabase.favoriteCoursesDao()
        }
    }
}