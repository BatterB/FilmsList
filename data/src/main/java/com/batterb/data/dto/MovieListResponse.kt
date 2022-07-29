package com.batterb.data.dto

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("status")
    val status : String,

    @SerializedName("copyright")
    val copyright : String,

    @SerializedName("has_more")
    val isEnd : Boolean,

    @SerializedName("num_results")
    val count : Int,

    @SerializedName("results")
    val movieList : List<MovieDto>
)