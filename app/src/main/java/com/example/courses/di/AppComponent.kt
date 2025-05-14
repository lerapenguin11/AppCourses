package com.example.courses.di

import android.content.Context
import com.example.courses.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context,
        ): AppComponent
    }

    fun inject(activity: MainActivity)
}