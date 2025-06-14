package com.example.ui.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme
import com.example.model.CourseInProfileUI
import com.example.model.CourseUI
import com.example.resources.R
import com.example.ui.button.BookmarkButton
import com.example.ui.button.TextButton
import com.example.ui.button.variant.TextButtonVariant
import com.example.ui.progress.ProgressCourse
import com.example.ui.spacer.VerticalSpacer
import com.example.ui.tag.CommonTag
import com.example.ui.tag.variant.TagVariant

@Composable
fun CourseCardInProfile(
    courseUI: CourseInProfileUI,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(size = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.darkGray
        )
    ) {
        CoursePreview(
            modifier = Modifier.padding(all = 8.dp),
            image = courseUI.image,
            rate = courseUI.rate,
            startDate = courseUI.startDate,
            isFavorite = courseUI.isFavorite,
            onClick = {}
        )
        VerticalSpacer(height = 16.dp)
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = courseUI.title,
                color = AppTheme.colors.white,
                style = AppTheme.typography.titleMedium
            )
            VerticalSpacer(height = 12.dp)
            ProgressCourse(
                progress = courseUI.progress,
                numberLessons = courseUI.numberLessons,
                completedLessons = courseUI.completedLessons,
            )
        }
    }
}

@Composable
fun CourseCard(
    courseUI: CourseUI,
    modifier: Modifier = Modifier,
    openCourseCard: (Int) -> Unit,
    toggleFavorite: (CourseUI) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(size = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.darkGray
        )
    ) {
        CoursePreview(
            modifier = Modifier.padding(all = 8.dp),
            image = courseUI.image,
            rate = courseUI.rate,
            startDate = courseUI.startDate,
            isFavorite = courseUI.isFavorite,
            onClick = {
                toggleFavorite(courseUI)
            }
        )
        VerticalSpacer(height = 16.dp)
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = courseUI.title,
                color = AppTheme.colors.white,
                style = AppTheme.typography.titleMedium
            )
            VerticalSpacer(height = 12.dp)
            Text(
                text = courseUI.description,
                color = AppTheme.colors.whiteOpacity,
                style = AppTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            VerticalSpacer(height = 10.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "${courseUI.price} ₽",
                    color = AppTheme.colors.white,
                    style = AppTheme.typography.titleMedium
                )
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        text = stringResource(id = R.string.more),
                        onClick = {
                            openCourseCard(courseUI.id)
                        },
                        variant = TextButtonVariant.Small
                    )
                    Icon(
                        painter = painterResource(id = Icons.ArrowRightShortFill),
                        contentDescription = null,
                        tint = AppTheme.colors.green
                    )
                }
            }
            VerticalSpacer(height = 16.dp)
        }
    }
}

@Composable
private fun CoursePreview(
    image: String?,
    rate: String,
    startDate: String,
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 114.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp,
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                ),
            contentScale = ContentScale.Crop,
            model = image,
            contentDescription = null
        )
        Box(
            modifier = modifier
                .matchParentSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
            ) {
                CommonTag(
                    text = rate,
                    variant = TagVariant.Star
                )
                CommonTag(
                    text = startDate,
                    variant = TagVariant.Ordinary
                )
            }
        }
        Box(
            modifier = modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            BookmarkButton(
                isFavorite = isFavorite,
                onClick = onClick::invoke,
            )
        }
    }
}

@Preview
@Composable
private fun CourseCardPreview() {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
        CourseCard(
            CourseUI(
                id = 1,
                image = "https://i.pinimg.com/736x/b9/a7/55/b9a75516248779bead50d84c52daebf3.jpg",
                rate = "4.9",
                startDate = "22 Мая 2024",
                isFavorite = true,
                title = "Java-разработчик с нуля",
                description = "Освойте backend-разработку \u2028и программирование на Java, фреймворки Spring и Maven, работу с базами данных и APIjjjjj. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
                price = "12 000",
                publishDate = ""
            ),
            openCourseCard = {},
            toggleFavorite = {}
        )
        VerticalSpacer(height = 16.dp)
        CourseCardInProfile(
            CourseInProfileUI(
                id = 1,
                image = "https://i.pinimg.com/736x/b9/a7/55/b9a75516248779bead50d84c52daebf3.jpg",
                rate = "4.9",
                startDate = "22 Мая 2024",
                isFavorite = true,
                title = "Java-разработчик с нуля",
                progress = 20,
                numberLessons = 10,
                completedLessons = 5
            ),
        )
    }
}