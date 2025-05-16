package com.example.courses.presentation

import BottomAppBar
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.courses.ui.AppState
import com.example.courses.ui.CourseApp
import com.example.courses.ui.rememberAppState
import com.example.designsystem.theme.AppTheme
import com.example.navigation.BottomBarRoute
import com.example.navigation.BottomNavigationItems
import com.example.navigation.InitialRoute
import com.example.ui.loading.LoadingComponent
import com.example.ui.local.LocalCoroutineScope
import com.example.ui.local.LocalSnackbarHostState

private lateinit var appState: AppState

@Composable
fun AppHost(
    viewModel: MainNavigationViewModel,
    modifier: Modifier = Modifier,
) {
    val startDestinationState by viewModel.startDestination.collectAsState()
    appState = rememberAppState()

    val startDestination = when (startDestinationState) {
        StartDestination.MainApp -> BottomBarRoute.Home.route
        StartDestination.Onboarding -> InitialRoute.Onboarding.route
        else -> null
    }
    val visibleEntries by appState.navController.visibleEntries.collectAsState()
    val isBottomNavigationBarVisible = visibleEntries.any { entry ->
        BottomNavigationItems.any { bottomItem ->
            bottomItem.route.route == entry.destination.route
        }
    }

    CompositionLocalProvider(
        values = arrayOf(
            LocalSnackbarHostState provides remember { SnackbarHostState() },
            LocalCoroutineScope provides rememberCoroutineScope(),
        )
    ) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            containerColor = AppTheme.colors.dark,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            bottomBar = {
                AnimatedVisibility(
                    visible = isBottomNavigationBarVisible,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    BottomAppBar(
                        navController = appState.navController,
                        onNavigationSelected = { selected ->
                            appState.navController.navigate(selected) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(appState.navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                            }

                        }
                    )
                }
            }
        ) { innerPadding ->
            if (startDestination == null) {
                LoadingComponent()
            } else {
                CourseApp(
                    innerPadding = innerPadding,
                    appState = appState,
                    startDestination = startDestination,
                    onCompleteOnboarding = {
                        viewModel.completeOnboarding()
                    }
                )
            }
        }
    }
}