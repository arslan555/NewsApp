package com.arslan.home.presentation

import com.arslan.model.TrendingNews


sealed interface TrendingNewsUIState {
    data class Success(val trendingNews: TrendingNews) : TrendingNewsUIState
    data class Error(val message: String) : TrendingNewsUIState
    object Loading : TrendingNewsUIState
}

