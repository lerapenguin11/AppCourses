package com.example.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.BottomBarRoute
import com.example.profile.ui.ProfileScreen

fun NavController.navigateToProfileScreen() = navigate(route = BottomBarRoute.Profile.route)

fun NavGraphBuilder.profileScreen() {
    composable(route = BottomBarRoute.Profile.route) {
        ProfileScreen()
    }
}