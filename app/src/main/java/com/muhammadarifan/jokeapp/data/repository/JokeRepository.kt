package com.muhammadarifan.jokeapp.data.repository

import com.muhammadarifan.jokeapp.data.remote.model.JokeRemoteData
import com.muhammadarifan.jokeapp.util.ResourceState
import kotlinx.coroutines.flow.Flow

interface JokeRepository {
    suspend fun getJokes(limit: Int): Flow<ResourceState<List<JokeRemoteData>>>
}