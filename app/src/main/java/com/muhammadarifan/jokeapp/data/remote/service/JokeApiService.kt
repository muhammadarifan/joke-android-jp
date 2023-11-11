package com.muhammadarifan.jokeapp.data.remote.service

import com.muhammadarifan.jokeapp.constant.NetworkConstant
import com.muhammadarifan.jokeapp.data.remote.model.JokeRemoteData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface JokeApiService {
    @GET("jokes")
    suspend fun getJokes(
        @Header("X-Api-Key") apiKey: String = NetworkConstant.API_NINJAS_API_KEY,
        @Query("limit") limit: Int,
    ): Response<List<JokeRemoteData>>
}