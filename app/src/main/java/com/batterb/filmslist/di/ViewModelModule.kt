package com.batterb.filmslist.di

import android.content.Context
import com.batterb.domain.usecases.MoviesUseCase
import com.batterb.filmslist.presentation.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(private val context: Context) {
    @Provides
    fun provideContext() : Context{
        return context
    }

    @Provides
    fun provideMoviesViewModel(moviesUseCaseImpl: MoviesUseCase) : MoviesViewModelFactory{
        return MoviesViewModelFactory(moviesUseCaseImpl)
    }
}