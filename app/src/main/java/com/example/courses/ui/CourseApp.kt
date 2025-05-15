package com.example.courses.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.courses.navigation.AppNavigation
import com.example.courses.presentation.MainNavigationViewModel

@Composable
fun CourseApp(
    innerPadding: PaddingValues,
    appState: AppState = rememberAppState(),
    startDestination: String,
    onCompleteOnboarding: () -> Unit,
) {
    AppNavigation(
        appState = appState,
        innerPadding = innerPadding,
        startDestination = startDestination,
        onCompleteOnboarding = onCompleteOnboarding::invoke
    )
}