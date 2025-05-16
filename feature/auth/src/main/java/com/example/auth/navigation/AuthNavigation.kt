package com.example.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.ui.AuthScreen
import kotlinx.serialization.Serializable

@Serializable
object AuthScreenRoute

fun NavController.navigateToAuthScreen(popUpToRoute: String? = null) = navigate(route = AuthScreenRoute){
    popUpToRoute?.let {
        popUpTo(route = it){
            inclusive = true
        }
    }
}

fun NavGraphBuilder.authScreen(
    onLogin: () -> Unit,
    openLinkInBrowser: (String) -> Unit,
){
    composable<AuthScreenRoute>{
        AuthScreen(
            onLogin = onLogin::invoke,
            openLinkInBrowser = openLinkInBrowser::invoke
        )
    }
}