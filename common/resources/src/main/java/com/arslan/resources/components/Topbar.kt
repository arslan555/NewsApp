package com.arslan.resources.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arslan.resources.R

@SuppressLint("ComposableNaming")
@Composable
fun NewsTopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(100.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = null,
        )

    }
}
@SuppressLint("ComposableNaming")
@Preview
@Composable
fun PreviewToolbar() {
    NewsTopBar()
}
