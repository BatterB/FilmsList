package com.batterb.filmslist.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.batterb.domain.models.MovieModel
import com.batterb.domain.usecases.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val moviesUseCase : MoviesUseCase
) :ViewModel() {

    private var _movieList = MutableLiveData<List<MovieModel>>()
    val movieList : LiveData<List<MovieModel>>
        get() = _movieList

    private var _isLoading = false
    val isLoading : Boolean
        get() = _isLoading


    private var _offset = 0

    fun loadMovies(){
        viewModelScope.launch {
            _isLoading = true
            withContext(Dispatchers.IO) {
                _movieList.postValue(moviesUseCase.getMovieList(_offset))
            }
            _isLoading = false
            _offset++
        }
    }
}