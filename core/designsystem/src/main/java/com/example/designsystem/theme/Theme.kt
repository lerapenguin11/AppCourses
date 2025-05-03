package com.example.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides TypographyValue,
        LocalColors provides BasePalette,
        content = content
    )
}

object AppTheme {
    val typography: AppTypography
        @Composable get() = LocalTypography.current
    val colors: ColorPalette
        @Composable @ReadOnlyComposable get() = LocalColors.current
}