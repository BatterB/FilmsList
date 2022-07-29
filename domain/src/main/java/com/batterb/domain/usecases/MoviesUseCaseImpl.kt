package com.batterb.domain.usecases

import com.batterb.domain.models.MovieModel
import com.batterb.domain.repository.MovieRepository
import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : MoviesUseCase {

    override suspend fun getMovieList(offset: Int) : List<MovieModel> {
        val countMovieOnPage = 20
        return movieRepository.getMoviesList(offset * countMovieOnPage)
    }
}