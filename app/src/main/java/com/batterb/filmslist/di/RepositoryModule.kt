package com.batterb.filmslist.di

import com.batterb.data.network.ApiService
import com.batterb.data.repository.MovieRepositoryImpl
import com.batterb.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMovieRepository(apiService: ApiService) : MovieRepository{
        return MovieRepositoryImpl(apiService)
    }
}