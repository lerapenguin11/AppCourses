package com.example.ui.progress

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.SliderDefaults.drawStopIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.AppTheme
import com.example.resources.R
import com.example.ui.spacer.VerticalSpacer

@Composable
fun ProgressCourse(
    progress: Int,
    numberLessons: Int,
    completedLessons: Int,
    modifier: Modifier = Modifier,
    track: Float = 100f,
) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = AppTheme.colors.green)) {
            append(completedLessons.toString())
        }
        append("")
        withStyle(style = SpanStyle(color = AppTheme.colors.whiteOpacity)) {
            append("/$numberLessons ${stringResource(id = R.string.lessons)}")
        }
    }

    Column {
        Row(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = "$progress%",
                style = AppTheme.typography.caption,
                color = AppTheme.colors.green
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = annotatedString,
                style = AppTheme.typography.caption
            )
        }
        VerticalSpacer(height = 6.dp)
        LinearProgressIndicator(
            progress = { progress / track },
            modifier = modifier
                .fillMaxWidth(),
            color = AppTheme.colors.green,
            trackColor = AppTheme.colors.stroke,
            gapSize = 4.dp,
            strokeCap = StrokeCap.Round,
            drawStopIndicator = {
                drawStopIndicator(
                    size = 0.dp,
                    color = Color.Transparent,
                    offset = Offset.Zero
                )
            },
        )
    }
}

@Preview
@Composable
private fun ProgressCoursePreview() {
    ProgressCourse(
        progress = 50,
        numberLessons = 10,
        completedLessons = 5,
    )
}