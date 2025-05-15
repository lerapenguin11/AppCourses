package com.example.courses.di

import android.content.Context
import com.example.courses.MainActivity
import com.example.domain.usecase.GetCoursesUseCase
import com.example.main.di.MainComponentDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent: MainComponentDependencies {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context,
        ): AppComponent
    }

    fun inject(activity: MainActivity)

    override val getCoursesUseCase: GetCoursesUseCase
}