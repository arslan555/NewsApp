package com.arslan.home.presentation

import com.arslan.home.model.TopHeadlines

sealed interface TrendingNewsUIState {
    data class Success(val topHeadlines: TopHeadlines) : TrendingNewsUIState
    data class Error(val message: String) : TrendingNewsUIState
    object Loading : TrendingNewsUIState
}

