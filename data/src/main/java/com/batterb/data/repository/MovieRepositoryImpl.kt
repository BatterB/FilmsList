package com.batterb.data.repository

import com.batterb.data.dto.asDomainModel
import com.batterb.data.network.ApiService
import com.batterb.domain.models.MovieModel
import com.batterb.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
    ) : MovieRepository {

    override suspend fun getMoviesList(offset: Int): List<MovieModel> {
        return apiService.getMoviesList(offset = offset).movieList.asDomainModel()
    }

}