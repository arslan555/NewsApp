package com.arslan.resources.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arslan.resources.R
import com.arslan.resources.theme.black
import com.arslan.resources.theme.purple

@SuppressLint("ComposableNaming")
@Composable
fun TrendingNews() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(220.dp)
            .background(MaterialTheme.colors.background)
            .padding(top = 16.dp, bottom = 8.dp)
    ) {
        RowHeader(title = "Trending")
        Image(
            painter = painterResource(id = R.drawable.news_image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,

            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
        )

        Text(
            text = "Europe",
            style = MaterialTheme.typography.caption.copy(color = purple),
            modifier = Modifier
                .padding(top = 8.dp)
        )

        Text(
            text = "Russian warship: Moskva sinks in Black Sea ",
            style = MaterialTheme.typography.subtitle1.copy(color = black),
            maxLines = 1,
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(top = 4.dp)
        )
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(top = 4.dp)
        ) {
            Text(
                text = "BBC News",
                style = MaterialTheme.typography.h6.copy(color = purple, fontSize = 13.sp)
            )
            Row(
                modifier = Modifier
                    .padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                )

                Text(
                    text = "4h ago",
                    style = MaterialTheme.typography.caption.copy(color = purple),
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(start = 4.dp)
                )
            }
        }


    }
}

@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewTrendingNews() {
    TrendingNews()
}