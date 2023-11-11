package com.muhammadarifan.jokeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammadarifan.jokeapp.data.remote.model.JokeRemoteData
import com.muhammadarifan.jokeapp.data.repository.JokeRepository
import com.muhammadarifan.jokeapp.util.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokeRepository: JokeRepository
): ViewModel() {
    private val _joke : MutableStateFlow<ResourceState<List<JokeRemoteData>>> = MutableStateFlow(ResourceState.Loading())
    val joke : StateFlow<ResourceState<List<JokeRemoteData>>> = _joke

    init {
        getJokes(10)
    }

    fun getJokes(limit: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            jokeRepository.getJokes(limit).collectLatest {
                _joke.value = it
            }
        }
    }
}