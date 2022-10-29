package com.arslan.home.data

import com.arslan.data.DataState
import com.arslan.home.model.TopHeadlines
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHeadlinesStream() : Flow<DataState<TopHeadlines>>
}