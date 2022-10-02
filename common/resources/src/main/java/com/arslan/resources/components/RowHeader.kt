package com.arslan.resources.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arslan.resources.theme.black
import com.arslan.resources.theme.purple

@Composable
fun RowHeader(title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(bottom = 2.dp, top = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6.copy(color = black),
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "See all",
            style = MaterialTheme.typography.caption.copy(color = purple),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable { onClick.invoke() }
        )
    }
}

@Preview
@Composable
fun PreviewRowHeader() {
    RowHeader(title = "Trending"){}
}