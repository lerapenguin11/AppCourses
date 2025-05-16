package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.courses.presentation.AppHost
import com.example.designsystem.theme.AppTheme
import com.example.di.DaggerViewModelProvider

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel =
                DaggerViewModelProvider.daggerViewModel { (application as App).appComponent.getViewModel() }

            AppTheme {
                AppHost(
                    viewModel = viewModel
                )
            }
        }
    }
}