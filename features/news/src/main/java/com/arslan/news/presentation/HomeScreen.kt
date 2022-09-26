package com.arslan.news.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arslan.resources.components.*

@SuppressLint("ComposableNaming")
@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
        topBar = { NewsTopBar() },
        content = {
            Column(modifier = Modifier.padding(top = 16.dp)) {
                SearchBar()
                TrendingNews()
                LatestNews()
            }
        })
}


@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewHomeScreen() {
    HomeScreen()
}


