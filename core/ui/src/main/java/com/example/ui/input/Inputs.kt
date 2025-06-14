package com.example.ui.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.AppTheme
import com.example.ui.spacer.VerticalSpacer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonInputs(
    label: Int,
    value: String,
    placeholder: Int,
    modifier: Modifier = Modifier,
    error: Int? = null,
    onValueChange: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val colors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = AppTheme.colors.lightGray,
        unfocusedContainerColor = AppTheme.colors.lightGray,
        unfocusedBorderColor = Color.Transparent,
        focusedBorderColor = Color.Transparent,
        cursorColor = AppTheme.colors.whiteOpacity,
    )
    Text(
        text = stringResource(id = label),
        color = AppTheme.colors.white,
        style = AppTheme.typography.titleMedium,
    )
    VerticalSpacer(height = 8.dp)
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 42.dp),
        value = value,
        onValueChange = onValueChange,
        textStyle = AppTheme.typography.bodyMedium.copy(
            color = AppTheme.colors.whiteOpacity
        )
    ){
        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = it,
            singleLine = true,
            enabled = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            colors = colors,
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 11.dp
            ),
            placeholder = {
                Text(
                    text = stringResource(id = placeholder),
                    color = AppTheme.colors.whiteOpacity,
                    style = AppTheme.typography.bodyMedium,
                )
            },
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    colors = colors,
                    shape = RoundedCornerShape(size = 30.dp),
                    enabled = true,
                    isError = false,
                    interactionSource = interactionSource,
                )
            },
        )
    }
    VerticalSpacer(height = 4.dp)
    AnimatedVisibility(
        visible = error != null,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        error?.let {
            Text(
                text = stringResource(id = it),
                color = AppTheme.colors.error,
                style = AppTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview
@Composable
private fun CommonInputsPreview() {
    CommonInputs(
        value = "",
        placeholder = com.example.resources.R.string.home,
        onValueChange = {},
        label = com.example.resources.R.string.home,
    )
}