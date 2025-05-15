package com.example.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.designsystem.icon.Icons

sealed class BottomBarRoute(var route: String) {
    data object Home : BottomBarRoute("home")
    data object Favorite : BottomBarRoute("favorite")
    data object Profile : BottomBarRoute("profile")
}

sealed class InitialRoute(var route: String) {
    data object Onboarding : InitialRoute("onboarding")
}

sealed class BottomTab(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: BottomBarRoute
) {
    data object Home : BottomTab(
        title = com.example.resources.R.string.home,
        icon = Icons.NavHome,
        route = BottomBarRoute.Home
    )

    data object Favorite : BottomTab(
        title = com.example.resources.R.string.favorite,
        icon = Icons.NavFavorite,
        route = BottomBarRoute.Favorite
    )

    data object Profile : BottomTab(
        title = com.example.resources.R.string.profile,
        icon = Icons.NavProfile,
        route = BottomBarRoute.Profile
    )
}

val BottomNavigationItems = listOf(
    BottomTab.Home,
    BottomTab.Favorite,
    BottomTab.Profile,
)