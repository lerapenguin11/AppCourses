package com.example.ui.button.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme
import com.example.ui.button.style.param.SocialAuthButtonParams
import com.example.ui.button.variant.SocialAuthButtonVariant

class SocialAuthButtonStyleImpl(private val params: SocialAuthButtonParams) :
    SocialAuthButtonStyle {
    override fun getBackgroundButton(variant: SocialAuthButtonVariant): Brush {
        return when (variant) {
            SocialAuthButtonVariant.Vk -> params.vkBackground
            SocialAuthButtonVariant.Ok -> params.okBackground
        }
    }

    override fun getIconButton(variant: SocialAuthButtonVariant): Int {
        return when (variant) {
            SocialAuthButtonVariant.Vk -> params.vkIcon
            SocialAuthButtonVariant.Ok -> params.okIcon
        }
    }
}

internal object SocialAuthButtonDefault {
    @Composable
    fun default(
        vkBackground: Brush = Brush.verticalGradient(
            listOf(
                AppTheme.colors.blue,
                AppTheme.colors.blue,
            )
        ),
        okBackground: Brush = AppTheme.colors.orangeGradient,
        vkIcon: Int = Icons.VkLogo,
        okIcon: Int = Icons.OkLogo,
    ): SocialAuthButtonStyleImpl {
        return SocialAuthButtonStyleImpl(
            params = SocialAuthButtonParams(
                vkBackground = vkBackground,
                vkIcon = vkIcon,
                okIcon = okIcon,
                okBackground = okBackground,
            )
        )
    }
}


private interface SocialAuthButtonStyle {
    fun getBackgroundButton(variant: SocialAuthButtonVariant): Brush
    fun getIconButton(variant: SocialAuthButtonVariant): Int
}