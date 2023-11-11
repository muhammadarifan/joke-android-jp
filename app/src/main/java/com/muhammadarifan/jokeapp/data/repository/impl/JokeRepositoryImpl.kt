package com.muhammadarifan.jokeapp.data.repository.impl

import com.muhammadarifan.jokeapp.data.remote.datasource.JokeDataSource
import com.muhammadarifan.jokeapp.data.remote.model.JokeRemoteData
import com.muhammadarifan.jokeapp.data.repository.JokeRepository
import com.muhammadarifan.jokeapp.util.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val jokeDataSource: JokeDataSource
): JokeRepository {
    override suspend fun getJokes(limit: Int): Flow<ResourceState<List<JokeRemoteData>>> {
        return flow {
            emit(ResourceState.Loading())
            try {
                val response = jokeDataSource.getJokes(limit)
                if (response.isSuccessful) {
                    emit(ResourceState.Success(response.body()!!))
                } else {
                    emit(ResourceState.Error(response.message()))
                }
            } catch (e: Exception) {
                emit(ResourceState.Error(e.message ?: "Unknown error"))
            }
        }
    }
}