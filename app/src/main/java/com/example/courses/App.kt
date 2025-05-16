package com.example.courses

import android.app.Application
import com.example.courses.di.AppComponent
import com.example.courses.di.AppComponentDependencies
import com.example.courses.di.AppComponentDependenciesProvider
import com.example.courses.di.DaggerAppComponent
import com.example.main.di.MainComponentDependencies
import com.example.main.di.MainComponentDependenciesProvider

class App : Application(), MainComponentDependenciesProvider, AppComponentDependenciesProvider {

    val appComponent: AppComponent by lazy { initializeComponent() }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun getMainComponentDependencies(): MainComponentDependencies {
        return appComponent
    }

    override fun getAppComponentDependencies(): AppComponentDependencies {
        return appComponent
    }

}