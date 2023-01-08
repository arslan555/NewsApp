package com.arslan.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arslan.data.DataState
import com.arslan.home.data.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _state = MutableStateFlow<TrendingNewsUIState>(TrendingNewsUIState.Loading)
    val state: StateFlow<TrendingNewsUIState>
        get() = _state
    init {
        viewModelScope.launch {
            _state.value  = TrendingNewsUIState.Loading
        homeRepository.getTrendingNewsStream().collect{ dataState ->
               when(dataState) {
                   is DataState.Success -> {
                       _state.value = TrendingNewsUIState.Success(dataState.data)
                       Timber.d(dataState.data.articles.toString() )

                   }
                   is DataState.Error -> {
                       _state.value = TrendingNewsUIState.Error(dataState.message)
                       Timber.d(dataState.message)
                   }
               }

           }
        }
    }
}