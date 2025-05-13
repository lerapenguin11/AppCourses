package com.example.profile.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.Icons
import com.example.designsystem.theme.AppTheme

@Composable
internal fun ProfileNavigationButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 41.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.darkGray,
        ),
        shape = RoundedCornerShape(0.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        onClick = onClick::invoke,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = text,
                style = AppTheme.typography.button,
                color = AppTheme.colors.white
            )
            Spacer(modifier = Modifier.weight(1F))
            Icon(
                painter = painterResource(id = Icons.ArrowRight),
                contentDescription = null,
                tint = AppTheme.colors.white,
            )
        }
    }
}

@Preview
@Composable
private fun ProfileNavigationButtonPreview() {
    ProfileNavigationButton(
        text = "fdjgbfgkfj",
        onClick = {}
    )
}