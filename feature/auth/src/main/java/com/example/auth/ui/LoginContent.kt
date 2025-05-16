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
import com.example.auth.presentation.LoginValidationKeys
import com.example.auth.ui.component.AuthAction
import com.example.auth.ui.model.LoginContentUi
import com.example.resources.R
import com.example.ui.button.MainButton
import com.example.ui.button.TextButton
import com.example.ui.button.variant.MainButtonVariant
import com.example.ui.button.variant.TextButtonVariant
import com.example.ui.input.CommonInputs
import com.example.ui.spacer.VerticalSpacer

@Composable
internal fun LoginContent(
    loginContentUi: LoginContentUi,
    modifier: Modifier = Modifier,
    openRegistrationScreen: () -> Unit,
    onLogin: () -> Unit,
    onValuePassword: (String) -> Unit,
    onValueEmail: (String) -> Unit,
) {
    CommonInputs(
        value = loginContentUi.email,
        placeholder = R.string.email_placeholder,
        onValueChange = onValueEmail::invoke,
        label = R.string.email_label,
        error = loginContentUi.error[LoginValidationKeys.Email],
    )
    VerticalSpacer(height = 16.dp)
    CommonInputs(
        value = loginContentUi.password,
        placeholder = R.string.first_password_placeholder,
        onValueChange = onValuePassword::invoke,
        label = R.string.first_password_label,
        error = loginContentUi.error[LoginValidationKeys.Password],
    )
    VerticalSpacer(height = 24.dp)
    MainButton(
        text = stringResource(id = R.string.login),
        variant = MainButtonVariant.Primary,
        onClick = onLogin::invoke
    )
    VerticalSpacer(height = 16.dp)
    AuthAction(
        descriptionText = stringResource(id = R.string.no_account),
        textButton = stringResource(id = R.string.registration),
        onClick = openRegistrationScreen::invoke,
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
        LoginContent(
            openRegistrationScreen = {},
            onLogin = {},
            loginContentUi = LoginContentUi(),
            onValuePassword = {},
            onValueEmail = {}
        )
    }
}