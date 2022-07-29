package com.batterb.data.network

import com.batterb.data.BuildConfig
import com.batterb.data.dto.MovieListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("./svc/movies/v2/reviews/all.json")
    suspend fun getMoviesList(
        @Query("offset") offset : Int,
        @Query("api-key") apiKey : String = BuildConfig.API_KEY
    ) : MovieListResponse

}