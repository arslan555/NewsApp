package com.arslan.news.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.arslan.resources.R
import com.arslan.resources.theme.black
import com.arslan.resources.theme.purple
import com.arslan.resources.theme.purpleLight


@SuppressLint("ComposableNaming")
@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
        topBar = { NewsTopBar() },
        content = {
            Column(modifier = Modifier.padding(top = 16.dp)) {
                SearchBar()
                TrendingNews()
            }
        })
}

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
@Composable
fun SearchBar() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colors.background)
            .border(BorderStroke(3.dp, purple), RoundedCornerShape(15.dp))
    ) {
        val (searchIcon, inputText, filterIcon) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.constrainAs(searchIcon) {
                start.linkTo(parent.start, margin = 10.dp)
                top.linkTo(parent.top, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            }
        )

        Text(text = "Search",
            style = MaterialTheme.typography.body1.copy(color = purpleLight),
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .constrainAs(inputText) {
                    start.linkTo(searchIcon.end, margin = 12.dp)
                    end.linkTo(filterIcon.start, margin = 12.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                })
        Image(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = null,
            modifier = Modifier.constrainAs(filterIcon) {
                end.linkTo(parent.end, margin = 10.dp)
                top.linkTo(parent.top, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            }
        )
    }
}

@SuppressLint("ComposableNaming")
@Composable
fun TrendingNews() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(220.dp)
            .background(MaterialTheme.colors.background)
            .padding(top = 16.dp)
    ) {
        val (trendingText, seeAllText, image, regionText, titleText, channelText, timeText) = createRefs()
        Text(text = "Trending",
            style = MaterialTheme.typography.h6.copy(color = black),
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(bottom = 8.dp)
                .constrainAs(trendingText) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(image.top)
                })

        Text(text = "See all",
            style = MaterialTheme.typography.caption.copy(color = purple),
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(bottom = 8.dp)
                .constrainAs(seeAllText) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(image.top)
                })
        Image(
            painter = painterResource(id = R.drawable.news_image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,

            modifier = Modifier
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .height(180.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
        )

        Text(text = "Europe",
            style = MaterialTheme.typography.caption.copy(color = purple),
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(top = 8.dp)
                .constrainAs(regionText) {
                    start.linkTo(parent.start)
                    top.linkTo(image.bottom)
                    width = Dimension.fillToConstraints
                })
        Text(text = "Russian warship: Moskva sinks in Black Sea ",
            style = MaterialTheme.typography.subtitle1.copy(color = black),
            maxLines = 1,
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(top = 4.dp)
                .constrainAs(titleText) {
                    start.linkTo(parent.start)
                    top.linkTo(regionText.bottom)
                    width = Dimension.fillToConstraints
                })
        Text(text = "BBC News",
            style = MaterialTheme.typography.h6.copy(color = purple, fontSize = 13.sp),
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(top = 4.dp)
                .constrainAs(channelText) {
                    start.linkTo(parent.start)
                    top.linkTo(titleText.bottom)
                })


        Row(
            modifier = Modifier
                .constrainAs(timeText) {
                    start.linkTo(channelText.end)
                    top.linkTo(titleText.bottom)
                }
                .padding(top = 4.dp, start = 12.dp),
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

@SuppressLint("ComposableNaming")
@Composable
fun LatestNews() {

}

@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewToolbar() {
    NewsTopBar()
}

@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewSearchBar() {
    SearchBar()
}

@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewTrendingNews() {
    TrendingNews()
}

@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewHomeScreen() {
    HomeScreen()
}


