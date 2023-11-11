package com.muhammadarifan.jokeapp.di

import com.muhammadarifan.jokeapp.data.remote.datasource.JokeDataSource
import com.muhammadarifan.jokeapp.data.repository.JokeRepository
import com.muhammadarifan.jokeapp.data.repository.impl.JokeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideJokeRepository(jokeDataSource: JokeDataSource): JokeRepository {
        return JokeRepositoryImpl(jokeDataSource)
    }
}