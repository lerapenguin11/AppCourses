package com.example.main.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme

@Composable
internal fun FilterButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
){
    IconButton(
        modifier = modifier.size(56.dp),
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = AppTheme.colors.darkGray,
            contentColor = AppTheme.colors.white,
        )
    ){
        Icon(
            painter = painterResource(id = Icons.Funnel),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
private fun FilterButtonPreview() {
    FilterButton(){}
}