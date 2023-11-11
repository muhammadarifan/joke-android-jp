package com.muhammadarifan.jokeapp.di

import com.muhammadarifan.jokeapp.data.remote.datasource.JokeDataSource
import com.muhammadarifan.jokeapp.data.remote.datasource.impl.JokeDataSourceImpl
import com.muhammadarifan.jokeapp.data.remote.service.JokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideJokeDataSource(jokeApiService: JokeApiService): JokeDataSource {
        return JokeDataSourceImpl(jokeApiService)
    }
}