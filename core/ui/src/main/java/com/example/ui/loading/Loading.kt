package com.example.ui.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.CircularProgressIndicator
import androidx.wear.compose.material3.ProgressIndicatorDefaults
import com.example.designsystem.theme.AppTheme

@Composable
fun LoadingComponent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(size = 42.dp),
            colors = ProgressIndicatorDefaults.colors(
                indicatorColor = AppTheme.colors.green,
                trackColor = AppTheme.colors.stroke,
            ),
            strokeWidth = 2.dp,
            gapSize = 2.dp
        )
    }
}