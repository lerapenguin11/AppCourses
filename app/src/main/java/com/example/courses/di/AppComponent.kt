package com.example.courses.di

import android.content.Context
import com.example.courses.MainActivity
import com.example.courses.presentation.MainNavigationViewModel
import com.example.domain.data_store.OnboardingManager
import com.example.domain.usecase.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.GetFavoriteCoursesByIdUseCase
import com.example.main.di.MainComponentDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent: MainComponentDependencies, AppComponentDependencies {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context,
        ): AppComponent
    }

    fun inject(activity: MainActivity)
    fun getViewModel(): MainNavigationViewModel

    override val getCoursesUseCase: GetCoursesUseCase
    override val getFavoriteCoursesByIdUseCase: GetFavoriteCoursesByIdUseCase
    override val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase
    override val onboardingManager: OnboardingManager
}