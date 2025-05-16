package com.example.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.auth.ui.component.AuthAction
import com.example.resources.R
import com.example.ui.button.MainButton
import com.example.ui.button.variant.MainButtonVariant
import com.example.ui.input.CommonInputs
import com.example.ui.spacer.VerticalSpacer

@Composable
internal fun RegistrationContent(
    modifier: Modifier = Modifier,
    openLoginScreen: () -> Unit,
    onRegistration: () -> Unit,
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
    VerticalSpacer(height = 16.dp)
    CommonInputs(
        value = "",
        placeholder = R.string.second_password_placeholder,
        onValueChange = {},
        label = R.string.second_password_label,
    )
    VerticalSpacer(height = 24.dp)
    MainButton(
        text = stringResource(id = R.string.registration),
        variant = MainButtonVariant.Primary,
        onClick = onRegistration::invoke
    )
    VerticalSpacer(height = 16.dp)
    AuthAction(
        descriptionText = stringResource(id = R.string.already_have_account),
        textButton = stringResource(id = R.string.sign_in),
        onClick = openLoginScreen::invoke
    )
}

@Preview
@Composable
private fun RegistrationContentPreview() {
    Column {
        RegistrationContent(
            openLoginScreen = {},
            onRegistration = {}
        )
    }
}