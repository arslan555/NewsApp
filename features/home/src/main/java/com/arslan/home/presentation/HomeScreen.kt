package com.arslan.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arslan.model.TrendingNews
import com.arslan.resources.components.*
import timber.log.Timber

@SuppressLint("ComposableNaming")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
        topBar = { NewsTopBar() },
        content = {
            val trendingNewsUIState by viewModel.state.collectAsState()
            Column(modifier = Modifier.padding(top = 16.dp)) {
                SearchBar()
                if (trendingNewsUIState is TrendingNewsUIState.Success) {
                    TrendingNews(
                        (trendingNewsUIState as TrendingNewsUIState.Success).trendingNews.articles[0],
                        seeAll = {
                            Timber.i("See All")
                        }) {
                        Timber.i(it)
                    }
                }
                LatestNews {
                    Timber.i("See All")
                }
            }
        }
    )
}


@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewHomeScreen() {
    //HomeScreen()
}

