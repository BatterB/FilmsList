package com.batterb.domain.repository

import com.batterb.domain.models.MovieModel

interface MovieRepository {
    suspend fun getMoviesList(offset : Int) : List<MovieModel>
}