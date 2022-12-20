package com.arslan.home.presentation

import com.arslan.home.model.TrendingNews

sealed interface TrendingNewsUIState {
    data class Success(val topHeadlines: TrendingNews) : TrendingNewsUIState
    data class Error(val message: String) : TrendingNewsUIState
    object Loading : TrendingNewsUIState
}

