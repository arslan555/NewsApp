package com.arslan.home.data

import com.arslan.data.DataState
import com.arslan.model.TrendingNews

import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getTrendingNews() : Flow<DataState<TrendingNews>>
    suspend fun getLatestNews(category: String) : Flow<DataState<TrendingNews>>
}