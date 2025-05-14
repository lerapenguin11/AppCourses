package com.example.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme
import com.example.ui.button.style.MainButtonDefault
import com.example.ui.button.style.MainButtonStyleImpl
import com.example.ui.button.style.SocialAuthButtonDefault
import com.example.ui.button.style.SocialAuthButtonStyleImpl
import com.example.ui.button.variant.MainButtonVariant
import com.example.ui.button.variant.SocialAuthButtonVariant
import com.example.ui.button.variant.TextButtonVariant

@Composable
fun MainButton(
    text: String,
    variant: MainButtonVariant,
    modifier: Modifier = Modifier,
    style: MainButtonStyleImpl = MainButtonDefault.default(),
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = style.getBackgroundColor(variant = variant)
        ),
        shape = RoundedCornerShape(size = 30.dp),
        contentPadding = PaddingValues(vertical = 10.dp),
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = AppTheme.typography.button,
            color = AppTheme.colors.white,
        )
    }
}

@Composable
fun TextButton(
    text: String,
    variant: TextButtonVariant,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onClick() }
            ),
        text = text,
        style = when(variant){
            TextButtonVariant.Small -> AppTheme.typography.buttonSmall
            TextButtonVariant.Medium -> AppTheme.typography.button
        },
        color = AppTheme.colors.green,
    )
}

@Composable
fun SocialAuthButton(
    variant: SocialAuthButtonVariant,
    modifier: Modifier = Modifier,
    style: SocialAuthButtonStyleImpl = SocialAuthButtonDefault.default(),
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .background(
                brush = style.getBackgroundButton(variant = variant),
                shape = RoundedCornerShape(size = 30.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true),
                onClick = { onClick() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = style.getIconButton(variant = variant)),
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun BookmarkButton(
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = AppTheme.colors.glass,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(all = 6.dp)
    ) {
        Icon(
            painter = painterResource(id = if (isFavorite) Icons.BookmarkFill else Icons.Bookmark),
            contentDescription = null,
            tint = if (isFavorite) AppTheme.colors.green else AppTheme.colors.whiteOpacity
        )
    }
}

@Preview
@Composable
private fun ButtonsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        MainButton(
            variant = MainButtonVariant.Secondary,
            onClick = {},
            text = "Начать курс"
        )
        TextButton(
            text = "Забыл пароль",
            onClick = {},
            variant = TextButtonVariant.Medium
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SocialAuthButton(
                modifier = Modifier
                    .weight(1f),
                variant = SocialAuthButtonVariant.Vk,
                onClick = {}
            )
            SocialAuthButton(
                modifier = Modifier
                    .weight(1f),
                variant = SocialAuthButtonVariant.Ok,
                onClick = {}
            )
        }
        BookmarkButton(
            isFavorite = true
        )
        BookmarkButton(
            isFavorite = false
        )
    }
}