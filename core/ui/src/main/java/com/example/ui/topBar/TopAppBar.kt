package com.example.ui.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            topBarState.title?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = topBarState.minHeaderHeight.dp),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text(
                        text = stringResource(id = it),
                        style = AppTheme.typography.titleLarge,
                        color = AppTheme.colors.white
                    )
                }
            }
        }
        if(topBarState.filterTopBar != null) {
            topBarState.filterTopBar.let { it() }
        }

    }
}