package com.example.ui.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme
import com.example.ui.tag.variant.TagVariant

@Composable
fun CommonTag(
    text: String,
    variant: TagVariant,
    modifier: Modifier = Modifier,
) {
    var containerSize by remember { mutableStateOf(Pair(0, 0)) }

    Box {
        BluerContainer(containerSize = containerSize)
        Row(
            modifier = modifier
                .padding(horizontal = 6.dp, vertical = 4.dp)
                .onSizeChanged {
                    containerSize = Pair(it.width, it.height)
                },
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (variant == TagVariant.Star){
                Icon(
                    painter = painterResource(id = Icons.StarFill),
                    contentDescription = null,
                    tint = AppTheme.colors.green
                )
            }
            Text(
                text = text,
                style = AppTheme.typography.caption,
                color = AppTheme.colors.white
            )
        }
    }
}

@Composable
private fun BluerContainer(
    modifier: Modifier = Modifier,
    containerSize: Pair<Int, Int>,
){
    val density = LocalDensity.current

    Box(
        modifier = modifier
            .background(
                color = AppTheme.colors.glass.copy(alpha = 0.7f),
                shape = RoundedCornerShape(size = 12.dp)
            )
            .blur(
                radius = 16.dp
            )
            .padding(horizontal = 6.dp, vertical = 4.dp)
            .width(with(density) { containerSize.first.toDp() })
            .height(with(density) { containerSize.second.toDp()})
    )
}

@Preview
@Composable
private fun CommonTagPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CommonTag(variant = TagVariant.Ordinary, text = "22 Мая 2024")
        CommonTag(variant = TagVariant.Star, text = "4.9")
    }
}