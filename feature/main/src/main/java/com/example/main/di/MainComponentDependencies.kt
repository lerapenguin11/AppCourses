package com.example.main.di

import com.example.domain.usecase.GetCoursesUseCase

interface MainComponentDependencies {
    val getCoursesUseCase: GetCoursesUseCase
}