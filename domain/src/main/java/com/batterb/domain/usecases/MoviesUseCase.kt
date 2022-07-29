package com.batterb.domain.usecases

import com.batterb.domain.models.MovieModel

interface MoviesUseCase {
    suspend fun getMovieList(offset: Int) : List<MovieModel>
}