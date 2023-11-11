package com.muhammadarifan.jokeapp.data.remote.datasource.impl

import com.muhammadarifan.jokeapp.data.remote.datasource.JokeDataSource
import com.muhammadarifan.jokeapp.data.remote.model.JokeRemoteData
import com.muhammadarifan.jokeapp.data.remote.service.JokeApiService
import retrofit2.Response
import javax.inject.Inject

class JokeDataSourceImpl @Inject constructor(
    private val jokeApiService: JokeApiService
): JokeDataSource {
    override suspend fun getJokes(limit: Int): Response<List<JokeRemoteData>> {
        return jokeApiService.getJokes(limit = limit)
    }
}