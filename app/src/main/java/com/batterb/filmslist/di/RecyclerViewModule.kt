package com.batterb.filmslist.di

import com.batterb.filmslist.presentation.movies.MoviesAdapter
import dagger.Module
import dagger.Provides

@Module
class RecyclerViewModule {

    @Provides
    fun provideMoviesAdapter() : MoviesAdapter{
        return MoviesAdapter()
    }

}