package com.example.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.AppTheme
import com.example.resources.R
import com.example.ui.button.SocialAuthButton
import com.example.ui.button.variant.SocialAuthButtonVariant
import com.example.ui.spacer.VerticalSpacer

@Composable
internal fun AuthScreen(
    modifier: Modifier = Modifier,
) {
    val screenType = AuthScreenType.Registration
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        VerticalSpacer(height = 100.dp)
        AuthScreenTitle(screenType = screenType)
        VerticalSpacer(height = 28.dp)
        when(screenType){
            AuthScreenType.Login -> LoginContent()
            AuthScreenType.Registration -> RegistrationContent()
        }
        VerticalSpacer(height = 32.dp)
        SocialBlock()
    }
}

@Composable
private fun SocialBlock(
    modifier: Modifier = Modifier,
){
    HorizontalDivider(
        color = AppTheme.colors.stroke,
        thickness = 1.dp,
    )
    VerticalSpacer(height = 32.dp)
    Row(
        modifier = modifier.fillMaxWidth(),
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
}

@Composable
private fun AuthScreenTitle(
    screenType: AuthScreenType,
    modifier: Modifier = Modifier,
){
    val title = when(screenType){
        AuthScreenType.Login -> stringResource(id = R.string.login)
        AuthScreenType.Registration -> stringResource(id = R.string.registration)
    }
    Text(
        text = title,
        color = AppTheme.colors.white,
        style = AppTheme.typography.headline,
    )
}

@Preview
@Composable
private fun AuthScreenPreview() {
    AuthScreen()
}