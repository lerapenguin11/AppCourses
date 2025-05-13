package com.example.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.main.ui.component.FilterContentRow
import com.example.main.ui.component.SortComponent
import com.example.model.CourseUI
import com.example.ui.card.CourseCard
import com.example.ui.spacer.VerticalSpacer
import com.example.ui.topBar.CommonContainer
import com.example.ui.topBar.TopBarState

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
){
    val list = listOf(
        CourseUI(
            id = 1,
            image = "https://i.pinimg.com/736x/b9/a7/55/b9a75516248779bead50d84c52daebf3.jpg",
            rate = "4.9",
            startDate = "22 Мая 2024",
            isFavorite = true,
            title = "Java-разработчик с нуля",
            description = "Освойте backend-разработку \u2028и программирование на Java, фреймворки Spring и Maven, работу с базами данных и APIjjjjj. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
            price = "12 000",
        ),
        CourseUI(
            id = 1,
            image = "https://i.pinimg.com/736x/b9/a7/55/b9a75516248779bead50d84c52daebf3.jpg",
            rate = "4.9",
            startDate = "22 Мая 2024",
            isFavorite = true,
            title = "Java-разработчик с нуля",
            description = "Освойте backend-разработку \u2028и программирование на Java, фреймворки Spring и Maven, работу с базами данных и APIjjjjj. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
            price = "12 000",
        ),
    )
    CommonContainer(
        topBarState = TopBarState(
            filterTopBar = {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.End
                ){
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
        ),
    ){
        LazyColumn(
            modifier = modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        ) {
            item {

            }
            items(items = list){
                CourseCard(
                    courseUI = it,
                    openCourseCard = {}
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}