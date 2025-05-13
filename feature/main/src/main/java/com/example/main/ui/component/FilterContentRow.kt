package com.example.main.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.resources.R

@Composable
internal fun FilterContentRow(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    openFilter: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SearchInput(
            modifier = modifier.weight(1f),
            value = value,
            onValueChange = onValueChange,
            placeholder = stringResource(id = R.string.search_placeholder)
        )
        FilterButton(
            onClick = openFilter
        )
    }
}

@Preview
@Composable
private fun FilterContentRowPreview() {
    FilterContentRow(
        value = "",
        onValueChange = {},
        openFilter = {}
    )
}