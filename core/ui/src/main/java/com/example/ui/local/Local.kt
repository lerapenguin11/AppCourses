package com.example.ui.local

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.CoroutineScope

val LocalSnackbarHostState = staticCompositionLocalOf<SnackbarHostState> {
    error("No Snackbar Host State provided")
}

val LocalCoroutineScope = staticCompositionLocalOf<CoroutineScope> {
    error("No Coroutine Scope provided")
}