package com.example.courses

import android.app.Application
import com.example.courses.di.AppComponent
import com.example.courses.di.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent by lazy { initializeComponent() }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

}