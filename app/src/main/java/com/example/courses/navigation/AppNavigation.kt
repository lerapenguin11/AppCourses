package com.example.courses.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.courses.presentation.MainNavigationViewModel
import com.example.courses.ui.AppState
import com.example.courses.ui.OnboardingScreen
import com.example.main.navigation.favoriteScreen
import com.example.main.navigation.mainScreen
import com.example.navigation.InitialRoute
import com.example.profile.navigation.profileScreen

private const val MainGraph = "main_graph"

@Composable
fun AppNavigation(
    appState: AppState,
    innerPadding: PaddingValues,
    startDestination: String,
    modifier: Modifier = Modifier,
    onCompleteOnboarding: () -> Unit,
){
    val navController = appState.navController

    NavHost(
        modifier = modifier
            .fillMaxSize()
            .consumeWindowInsets(
                PaddingValues(
                    bottom = innerPadding.calculateBottomPadding()
                )
            )
            .padding(innerPadding),
        navController = navController,
        startDestination = startDestination,
        route = MainGraph
    ){
        composable(route = InitialRoute.Onboarding.route){
            OnboardingScreen(
                onNext = {
                    onCompleteOnboarding()
                }
            )
        }
        mainScreen()
        favoriteScreen()
        profileScreen()
    }
}