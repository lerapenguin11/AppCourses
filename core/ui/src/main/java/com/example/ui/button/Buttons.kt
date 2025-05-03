package com.example.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.AppTheme
import com.example.ui.button.style.MainButtonDefault
import com.example.ui.button.style.MainButtonStyle
import com.example.ui.button.variant.MainButtonVariant

@Composable
fun MainButton(
    text: String,
    variant: MainButtonVariant,
    modifier: Modifier = Modifier,
    style: MainButtonStyle = MainButtonDefault.default(),
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = style.getBackgroundColor(variant = variant)
        ),
        contentPadding = PaddingValues(vertical = 10.dp),
        onClick = onClick,
    ){
        Text(
            text = text,
            style = AppTheme.typography.button,
            color = AppTheme.colors.white,
        )
    }
}

@Preview
@Composable
private fun ButtonsPreview() {
    MainButton(
        variant = MainButtonVariant.Secondary,
        onClick = {},
        text = "Начать курс"
    )
}