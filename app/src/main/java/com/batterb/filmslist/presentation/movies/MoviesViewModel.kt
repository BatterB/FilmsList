package com.batterb.filmslist.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.batterb.domain.models.MovieModel
import com.batterb.domain.usecases.MoviesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val moviesUseCase : MoviesUseCase
) :ViewModel() {

    private var _movieList = MutableLiveData<List<MovieModel>>()
    val movieList : LiveData<List<MovieModel>>
        get() = _movieList

    fun loadMovies(offset : Int){
        viewModelScope.launch {
            _movieList.value = moviesUseCase.getMovieList(offset)
        }
    }
}