package com.example.auth.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.auth.ui.component.AuthAction
import com.example.resources.R
import com.example.ui.button.MainButton
import com.example.ui.button.TextButton
import com.example.ui.button.variant.MainButtonVariant
import com.example.ui.button.variant.TextButtonVariant
import com.example.ui.input.CommonInputs
import com.example.ui.spacer.VerticalSpacer

@Composable
internal fun LoginContent(
    modifier: Modifier = Modifier,
) {
    CommonInputs(
        value = "",
        placeholder = R.string.email_placeholder,
        onValueChange = {},
        label = R.string.email_label,
    )
    VerticalSpacer(height = 16.dp)
    CommonInputs(
        value = "",
        placeholder = R.string.first_password_placeholder,
        onValueChange = {},
        label = R.string.first_password_label,
    )
    VerticalSpacer(height = 24.dp)
    MainButton(
        text = stringResource(id = R.string.login),
        variant = MainButtonVariant.Primary,
        onClick = {}
    )
    VerticalSpacer(height = 16.dp)
    AuthAction(
        descriptionText = stringResource(id = R.string.no_account),
        textButton = stringResource(id = R.string.registration),
        onClick = {}
    )
    VerticalSpacer(height = 8.dp)
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        TextButton(
            text = stringResource(id = R.string.forgot_password),
            onClick = {},
            variant = TextButtonVariant.Small
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    Column {
        LoginContent()
    }
}