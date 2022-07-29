package com.batterb.filmslist.di

import com.batterb.filmslist.presentation.movies.MoviesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, NetworkModule::class,UseCasesModule::class,
    RepositoryModule::class, RecyclerViewModule::class])
interface AppComponent {
    fun inject(moviesActivity: MoviesActivity)
}