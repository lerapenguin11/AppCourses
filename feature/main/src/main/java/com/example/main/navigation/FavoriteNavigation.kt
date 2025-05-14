package com.example.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.main.ui.MainScreen
import com.example.navigation.BottomBarRoute

fun NavController.navigateToFavoriteScreen() = navigate(route = BottomBarRoute.Favorite.route)

fun NavGraphBuilder.favoriteScreen() {
    composable(route = BottomBarRoute.Favorite.route) {
        MainScreen()
    }
}