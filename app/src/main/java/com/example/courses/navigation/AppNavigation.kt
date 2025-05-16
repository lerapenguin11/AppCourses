package com.example.courses.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.auth.navigation.AuthScreenRoute
import com.example.auth.navigation.authScreen
import com.example.auth.navigation.navigateToAuthScreen
import com.example.courses.presentation.MainNavigationViewModel
import com.example.courses.ui.AppState
import com.example.courses.ui.OnboardingScreen
import com.example.main.navigation.favoriteScreen
import com.example.main.navigation.mainScreen
import com.example.main.navigation.navigateToMainScreen
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
) {
    val navController = appState.navController
    val context = LocalContext.current

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
    ) {
        composable(route = InitialRoute.Onboarding.route) {
            OnboardingScreen(
                onNext = {
                    onCompleteOnboarding()
                    navController.navigateToAuthScreen(popUpToRoute = InitialRoute.Onboarding.route)
                }
            )
        }
        mainScreen()
        favoriteScreen()
        profileScreen()
        authScreen(
            onLogin = {
                navController.navigateToMainScreen(popUpRoute = AuthScreenRoute)
            },
            openLinkInBrowser = {
                openLinkInBrowser(url = it, context = context)
            }
        )
    }
}

private fun openLinkInBrowser(url: String, context: Context) {
    context.startActivity(
        Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER).apply {
            data = Uri.parse(url)
        }
    )
}