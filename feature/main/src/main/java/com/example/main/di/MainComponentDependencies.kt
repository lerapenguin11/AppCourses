package com.example.main.di

import com.example.domain.usecase.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.GetFavoriteCoursesByIdUseCase

interface MainComponentDependencies {
    val getCoursesUseCase: GetCoursesUseCase
    val getFavoriteCoursesByIdUseCase: GetFavoriteCoursesByIdUseCase
    val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase
}