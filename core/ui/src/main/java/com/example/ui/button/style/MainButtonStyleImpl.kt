package com.example.ui.button.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.designsystem.theme.AppTheme
import com.example.ui.button.style.param.MainButtonStyleParams
import com.example.ui.button.variant.MainButtonVariant

class MainButtonStyleImpl(private val param: MainButtonStyleParams): MainButtonStyle {
    override fun getBackgroundColor(variant: MainButtonVariant): Color {
        return when(variant){
            MainButtonVariant.Primary -> param.primaryColorButton
            MainButtonVariant.Secondary -> param.secondaryColorButton
        }
    }
}

internal object MainButtonDefault {
    @Composable
    fun default(
        primaryColorButton: Color = AppTheme.colors.green,
        secondaryColorButton: Color = AppTheme.colors.darkGray,
    ): MainButtonStyleImpl {
        return MainButtonStyleImpl(
            param = MainButtonStyleParams(
                primaryColorButton = primaryColorButton,
                secondaryColorButton = secondaryColorButton,
            )
        )
    }
}

private interface MainButtonStyle {
    fun getBackgroundColor(variant: MainButtonVariant): Color
}