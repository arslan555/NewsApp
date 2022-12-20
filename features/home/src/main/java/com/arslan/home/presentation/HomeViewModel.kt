package com.arslan.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arslan.data.DataState
import com.arslan.home.data.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private var _trendingNewsUIState = MutableLiveData<TrendingNewsUIState>()
    var trendingNewsUIState: LiveData<TrendingNewsUIState> = _trendingNewsUIState
    init {
        viewModelScope.launch {
            _trendingNewsUIState.value  = TrendingNewsUIState.Loading
        homeRepository.getTrendingNewsStream().collect{ dataState ->
               when(dataState) {
                   is DataState.Success -> {
                        _trendingNewsUIState.value = TrendingNewsUIState.Success(dataState.data)
                       Timber.d(dataState.data.articles.toString() )

                   }
                   is DataState.Error -> {
                       _trendingNewsUIState.value = TrendingNewsUIState.Error(dataState.message)
                       Timber.d(dataState.message)
                   }
               }

           }
        }
    }
}