package com.example.courses.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.courses.navigation.AppNavigation

@Composable
fun CourseApp(
    innerPadding: PaddingValues,
    appState: AppState = rememberAppState(),
) {
    AppNavigation(
        appState = appState,
        innerPadding = innerPadding,
    )
}