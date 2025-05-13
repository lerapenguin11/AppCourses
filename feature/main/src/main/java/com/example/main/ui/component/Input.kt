package com.example.main.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme
import com.example.designsystem.utils.CommonDrawables
import com.example.resources.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchInput(
    placeholder: String,
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
){
    val interactionSource = remember { MutableInteractionSource() }
    val colors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = AppTheme.colors.darkGray,
        unfocusedContainerColor = AppTheme.colors.darkGray,
        unfocusedBorderColor = Color.Transparent,
        focusedBorderColor = Color.Transparent,
        cursorColor = AppTheme.colors.whiteOpacity,
    )

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        value = value,
        onValueChange = onValueChange,
        textStyle = AppTheme.typography.roboto14.copy(
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
                all = 4.dp
            ),
            prefix = {
                Icon(
                    modifier = Modifier.padding(end = 4.dp),
                    painter = painterResource(id = Icons.Search),
                    contentDescription = null,
                    tint = AppTheme.colors.white,
                )
            },
            placeholder = {
                Text(
                    text = placeholder,
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
}

@Preview
@Composable
private fun SearchInputPreview() {
    SearchInput(
        value = "",
        onValueChange = {},
        placeholder = stringResource(id = R.string.search_placeholder)
    )
}