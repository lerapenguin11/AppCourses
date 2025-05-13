package com.example.ui.topBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable

@Immutable
data class TopBarState(
    val filterTopBar: (@Composable () -> Unit)? = null,
    val title: Int? = null,
    val minHeaderHeight: Int = 60
)
