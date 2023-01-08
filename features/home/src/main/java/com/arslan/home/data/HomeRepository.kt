package com.arslan.home.data

import com.arslan.data.DataState
import com.arslan.model.TrendingNews

import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getTrendingNewsStream() : Flow<DataState<TrendingNews>>
}