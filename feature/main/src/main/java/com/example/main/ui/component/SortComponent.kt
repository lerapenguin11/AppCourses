package com.example.main.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme
import com.example.ui.button.TextButton
import com.example.ui.button.variant.TextButtonVariant
import com.example.resources.R

@Composable
internal fun SortComponent(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
    ) {
        TextButton(
            text = stringResource(id = R.string.sort_date),
            onClick = {},
            variant = TextButtonVariant.Medium
        )
        Icon(
            painter = painterResource(id = Icons.ArrowDownUp),
            contentDescription = null,
            tint = AppTheme.colors.green
        )
    }
}

@Preview
@Composable
private fun SortComponentPreview() {
    SortComponent()
}