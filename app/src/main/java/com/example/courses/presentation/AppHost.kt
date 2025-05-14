package com.example.courses.presentation

import BottomAppBar
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.courses.ui.AppState
import com.example.courses.ui.CourseApp
import com.example.courses.ui.rememberAppState
import com.example.designsystem.theme.AppTheme

private lateinit var appState: AppState

@Composable
fun AppHost(
    modifier: Modifier = Modifier,
) {
    appState = rememberAppState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = AppTheme.colors.dark,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            BottomAppBar(
                navController = appState.navController,
                onNavigationSelected = { selected ->
                    appState.navController.navigate(selected){
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(appState.navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }

                }
            )
        }
    ) { innerPadding ->
        CourseApp(
            innerPadding = innerPadding,
            appState = appState,
        )
    }
}