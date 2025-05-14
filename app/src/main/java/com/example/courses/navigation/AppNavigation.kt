package com.example.courses.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.courses.ui.AppState
import com.example.main.navigation.favoriteScreen
import com.example.main.navigation.mainScreen
import com.example.navigation.BottomBarRoute
import com.example.profile.navigation.profileScreen

private const val MainGraph = "main_graph"

@Composable
fun AppNavigation(
    appState: AppState,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
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
        startDestination = BottomBarRoute.Home.route,
        route = MainGraph
    ){
        mainScreen()
        favoriteScreen()
        profileScreen()
    }
}