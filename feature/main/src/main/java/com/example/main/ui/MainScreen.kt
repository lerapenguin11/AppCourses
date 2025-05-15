package com.example.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.main.presentation.MainUiState
import com.example.main.presentation.MainViewModel
import com.example.main.ui.component.FilterContentRow
import com.example.main.ui.component.SortComponent
import com.example.model.CourseUI
import com.example.resources.R
import com.example.ui.card.CourseCard
import com.example.ui.loading.LoadingComponent
import com.example.ui.spacer.VerticalSpacer
import com.example.ui.topBar.CommonContainer
import com.example.ui.topBar.TopBarState

@Composable
internal fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val screenType = viewModel.screenType.collectAsStateWithLifecycle().value
    val coursesUiState by viewModel.coursesUIState.collectAsStateWithLifecycle()

    CommonContainer(
        topBarState = TopBarState(
            filterTopBar = {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    if (ScreenType.Main == screenType) {
                        VerticalSpacer(height = 16.dp)
                        FilterContentRow(
                            value = "",
                            onValueChange = {},
                            openFilter = {}
                        )
                        VerticalSpacer(height = 16.dp)
                        SortComponent()
                    }
                }
            },
            title = when (screenType) {
                ScreenType.Main -> null
                ScreenType.Favorite -> R.string.favorite
            }
        ),
    ) {
        when (coursesUiState) {
            is MainUiState.Content -> {
                CoursesContent(
                    screenType = screenType,
                    courses = (coursesUiState as? MainUiState.Content)?.data,
                )
            }

            MainUiState.ErrorInitialLoading -> {
                println("ErrorInitialLoading")
            }
            MainUiState.Exception -> {
                println("Exception")
            }
            MainUiState.InitialLoading -> {
                LoadingComponent()
            }
        }
    }
}

@Composable
private fun CoursesContent(
    screenType: ScreenType,
    courses: List<CourseUI>?,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
    ) {
        courses?.let { list ->
            if (ScreenType.Main == screenType) {
                item { }
            }
            items(items = list) {
                CourseCard(
                    courseUI = it,
                    openCourseCard = {},
                    toggleFavorite = {},
                )
            }
        }
    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(viewModel = viewModel())
}