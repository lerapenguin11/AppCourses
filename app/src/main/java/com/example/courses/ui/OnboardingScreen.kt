package com.example.courses.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.designsystem.theme.AppTheme
import com.example.ui.button.MainButton
import com.example.ui.button.variant.MainButtonVariant
import com.example.ui.spacer.VerticalSpacer

private const val first_visible_item_scroll_offset = 500

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onNext: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalSpacer(height = 100.dp)
        Text(
            text = stringResource(id = R.string.onboarding_title),
            style = AppTheme.typography.headline,
            color = AppTheme.colors.white,
        )
        VerticalSpacer(height = 32.dp)
        LazyRow(
            modifier = Modifier.ignoreHorizontalParentPadding(),
            state = rememberLazyListState(initialFirstVisibleItemScrollOffset = first_visible_item_scroll_offset)
        ) {
            item {
                Image(
                    painter = painterResource(R.drawable.ic_courses),
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .padding(horizontal = 16.dp),
        ) {
            MainButton(
                text = stringResource(id = R.string.next),
                variant = MainButtonVariant.Primary,
                onClick = onNext::invoke,
            )
        }
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(){}
}