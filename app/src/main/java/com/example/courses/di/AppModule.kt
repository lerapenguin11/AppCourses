package com.example.courses.di

import com.example.data.di.DataModule
import com.example.domain.di.DomainModule
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        DomainModule::class,
    ]
)
interface AppModule