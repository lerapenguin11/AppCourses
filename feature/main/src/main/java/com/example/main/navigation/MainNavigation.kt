package com.example.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.main.ui.MainScreen
import com.example.navigation.BottomBarRoute

fun NavController.navigateToMainScreen() = navigate(route = BottomBarRoute.Home.route)

fun NavGraphBuilder.mainScreen() {
    composable(route = BottomBarRoute.Home.route) {
        MainScreen()
    }
}