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

fun NavController.navigateToMainScreen() = navigate(route = BottomBarRoute.Home.route)

fun NavGraphBuilder.mainScreen() {
    composable(route = BottomBarRoute.Home.route) {
        val mainScreenDependencies =
            (LocalContext.current.applicationContext as MainComponentDependenciesProvider).getMainComponentDependencies()
        val component =
            DaggerMainComponent.builder().mainComponentDependencies(mainScreenDependencies)
                .build()
        val viewModel = DaggerViewModelProvider.daggerViewModel { component.getViewModel() }
        viewModel.updateScreenType(screenType = ScreenType.Main)

        MainScreen(
            viewModel = viewModel,
        )
    }
}