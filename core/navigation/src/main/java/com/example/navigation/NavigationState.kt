package com.example.navigation

import androidx.navigation.NavHostController

class NavigationState(val navHostController: NavHostController) {
    fun navigateTo(
        route: String,
        inclusive: Boolean = false,
        popUpToScreen: String = BottomBarRoute.Home.route,
    ) {
        navHostController.navigate(route) {
            popUpTo(popUpToScreen) {
                this.inclusive = inclusive
            }
            launchSingleTop = true
        }
    }
}