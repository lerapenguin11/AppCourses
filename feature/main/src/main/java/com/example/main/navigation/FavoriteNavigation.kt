package com.example.main.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.di.DaggerViewModelProvider
import com.example.main.di.DaggerMainComponent
import com.example.main.di.MainComponentDependenciesProvider
import com.example.main.ui.MainScreen
import com.example.main.ui.ScreenType
import com.example.navigation.BottomBarRoute

fun NavController.navigateToFavoriteScreen() = navigate(route = BottomBarRoute.Favorite.route)

fun NavGraphBuilder.favoriteScreen() {
    composable(route = BottomBarRoute.Favorite.route) {
        val favoriteScreenDependencies =
            (LocalContext.current.applicationContext as MainComponentDependenciesProvider).getMainComponentDependencies()
        val component =
            DaggerMainComponent.builder().mainComponentDependencies(favoriteScreenDependencies)
                .build()
        val viewModel = DaggerViewModelProvider.daggerViewModel { component.getViewModel() }
        viewModel.updateScreenType(screenType = ScreenType.Favorite)

        MainScreen(viewModel = viewModel)
    }
}