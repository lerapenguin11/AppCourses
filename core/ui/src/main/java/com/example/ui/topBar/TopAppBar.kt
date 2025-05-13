package com.example.ui.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.AppTheme

@Composable
fun CommonContainer(
    topBarState: TopBarState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        CustomTopBar(topBarState = topBarState)
        content()
    }
}

@Composable
private fun CustomTopBar(
    topBarState: TopBarState,
    modifier: Modifier = Modifier,
){
    Surface(
        modifier = modifier
            .background(AppTheme.colors.dark),
        color = AppTheme.colors.dark
    ){
        if(topBarState.filterTopBar != null) {
            topBarState.filterTopBar.let { it() }
        }
    }
}