package com.example.main.di

import com.example.di.FeatureScope
import com.example.main.presentation.MainViewModel
import dagger.Component

@FeatureScope
@Component(
    dependencies = [MainComponentDependencies::class]
)
internal interface MainComponent {
    fun getViewModel(): MainViewModel
}