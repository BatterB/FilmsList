package com.batterb.filmslist.di

import com.batterb.domain.repository.MovieRepository
import com.batterb.domain.usecases.MoviesUseCase
import com.batterb.domain.usecases.MoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideMoviesUseCase (movieRepository: MovieRepository) :MoviesUseCase{
        return MoviesUseCaseImpl(movieRepository)
    }

}