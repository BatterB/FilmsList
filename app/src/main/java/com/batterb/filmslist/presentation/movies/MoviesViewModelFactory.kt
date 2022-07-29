package com.batterb.filmslist.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.batterb.domain.usecases.MoviesUseCase
import javax.inject.Inject

class MoviesViewModelFactory @Inject constructor(
    private val moviesUseCase : MoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(moviesUseCase) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}