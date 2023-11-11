package com.muhammadarifan.jokeapp.data.remote.datasource

import com.muhammadarifan.jokeapp.data.remote.model.JokeRemoteData
import retrofit2.Response

interface JokeDataSource {
    suspend fun getJokes(limit: Int): Response<List<JokeRemoteData>>
}