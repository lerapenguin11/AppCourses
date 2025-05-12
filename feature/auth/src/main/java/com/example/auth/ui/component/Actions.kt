package com.example.auth.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.example.designsystem.theme.AppTheme

@Composable
internal fun AuthAction(
    descriptionText: String,
    textButton: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
){
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = AppTheme.colors.white)) {
            append(descriptionText)
        }
        append(" ")
        withStyle(style = SpanStyle(color = AppTheme.colors.green)) {
            append(textButton)
        }
    }
    Text(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onClick() }
            ),
        text = annotatedString,
        style = AppTheme.typography.buttonSmall,
        textAlign = TextAlign.Center
    )
}