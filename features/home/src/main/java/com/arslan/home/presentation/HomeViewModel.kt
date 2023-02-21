package com.arslan.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arslan.data.DataState
import com.arslan.home.data.HomeRepository
import com.arslan.utils.CoroutineDispatchers
import com.arslan.utils.Dispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Dispatcher(CoroutineDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher,
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _trendingNewsUIState = MutableStateFlow<TrendingNewsUIState>(TrendingNewsUIState.Loading)
    val trendingNewsUIState: StateFlow<TrendingNewsUIState>
        get() = _trendingNewsUIState

    private val _latestNewsUIState = MutableStateFlow<LatestNewsUIState>(LatestNewsUIState.Loading)
    val latestNewsUIState: StateFlow<LatestNewsUIState>
        get() = _latestNewsUIState

    fun getTrendingNews() {
        viewModelScope.launch(ioDispatcher) {
            _trendingNewsUIState.value = TrendingNewsUIState.Loading
            homeRepository.getTrendingNews().collect { dataState ->
                when (dataState) {
                    is DataState.Success -> {
                        _trendingNewsUIState.value = TrendingNewsUIState.Success(dataState.data)
                        Timber.d(dataState.data.articles.toString())

                    }
                    is DataState.Error -> {
                        _trendingNewsUIState.value = TrendingNewsUIState.Error(dataState.message)
                        Timber.d(dataState.message)
                    }
                }

            }
        }

    }

    fun getLatestNews() {
        viewModelScope.launch(ioDispatcher) {
            _latestNewsUIState.value = LatestNewsUIState.Loading
            homeRepository.getTrendingNews().collect { dataState ->
                when (dataState) {
                    is DataState.Success -> {
                        _latestNewsUIState.value = LatestNewsUIState.Success(dataState.data)
                        Timber.d(dataState.data.articles.toString())

                    }
                    is DataState.Error -> {
                        _latestNewsUIState.value = LatestNewsUIState.Error(dataState.message)
                        Timber.d(dataState.message)
                    }
                }

            }
        }
    }
}