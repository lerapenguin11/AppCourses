package com.example.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.AppTheme
import com.example.model.CourseInProfileUI
import com.example.profile.ui.component.ProfileNavigationButton
import com.example.ui.topBar.CommonContainer
import com.example.ui.topBar.TopBarState
import com.example.resources.R
import com.example.ui.card.CourseCardInProfile
import com.example.ui.spacer.VerticalSpacer

@Composable
internal fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    CommonContainer(
        topBarState = TopBarState(
            title = R.string.user_profile,
        )
    ) {
        val courses = listOf(
            CourseInProfileUI(
                id = 1,
                image = null,
                rate = "4.9",
                startDate = "22 Мая 2024",
                isFavorite = true,
                title = "Java-разработчик с нуля",
                progress = 20,
                numberLessons = 10,
                completedLessons = 5
            ),
            CourseInProfileUI(
                id = 2,
                image = null,
                rate = "4.9",
                startDate = "22 Мая 2024",
                isFavorite = true,
                title = "Java-разработчик с нуля",
                progress = 20,
                numberLessons = 10,
                completedLessons = 5
            ),
            CourseInProfileUI(
                id = 3,
                image = null,
                rate = "4.9",
                startDate = "22 Мая 2024",
                isFavorite = true,
                title = "Java-разработчик с нуля",
                progress = 20,
                numberLessons = 10,
                completedLessons = 5
            ),
            CourseInProfileUI(
                id = 4,
                image = null,
                rate = "4.9",
                startDate = "22 Мая 2024",
                isFavorite = true,
                title = "Java-разработчик с нуля",
                progress = 20,
                numberLessons = 10,
                completedLessons = 5
            ),
        )

        LazyColumn(
            modifier = modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp)
        ) {
            item {
                ColumnProfileMenu(
                    writeSupport = {},
                    openSettings = {},
                    logOutAccount = {},
                )
                VerticalSpacer(height = 32.dp)
                Text(
                    text = stringResource(id = R.string.your_courses),
                    style = AppTheme.typography.titleLarge,
                    color = AppTheme.colors.white
                )
                VerticalSpacer(height = 16.dp)
            }
            items(items = courses, key = { it.id }){
                CourseCardInProfile(
                    courseUI = it
                )
                VerticalSpacer(height = 16.dp)
            }
        }
    }
}

@Composable
private fun ColumnProfileMenu(
    modifier: Modifier = Modifier,
    writeSupport: () -> Unit,
    openSettings: () -> Unit,
    logOutAccount: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = AppTheme.colors.darkGray,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .clip(shape = RoundedCornerShape(size = 16.dp))
    ) {
        ProfileNavigationButton(
            text = stringResource(id = R.string.write_support),
            onClick = writeSupport::invoke
        )
        MenuItemSeparator()
        ProfileNavigationButton(
            text = stringResource(id = R.string.settings),
            onClick = openSettings::invoke
        )
        MenuItemSeparator()
        ProfileNavigationButton(
            text = stringResource(id = R.string.log_out_account),
            onClick = logOutAccount::invoke,
        )
    }
}

@Composable
private fun MenuItemSeparator(
    modifier: Modifier = Modifier,
) {
    HorizontalDivider(
        modifier = modifier
            .padding(horizontal = 16.dp),
        thickness = 1.dp,
        color = AppTheme.colors.stroke
    )
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}