package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.example.courses.di.DaggerAppComponent
import com.example.courses.presentation.AppHost
import com.example.designsystem.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = DaggerAppComponent.factory().create(LocalContext.current).getViewModel()
            AppTheme {
                AppHost(
                    viewModel = viewModel
                )
            }
        }
    }
}