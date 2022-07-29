package com.batterb.data.dto

import com.batterb.domain.models.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("display_title")
    val title : String,

    @SerializedName("mpaa_rating")
    val ageRating : String,

    @SerializedName("critics_pick")
    val criticsPick : Int,

    @SerializedName("byline")
    val criticName : String,

    @SerializedName("headline")
    val headline : String,

    @SerializedName("summary_short")
    val shortReview : String,

    @SerializedName("publication_date")
    val publicationDate : String,

    @SerializedName("opening_date")
    val openingDate : String,

    @SerializedName("date_updated")
    val dateUpdated : String,

    @SerializedName("link")
    val reviewLink : ReviewLinkDto,

    @SerializedName("multimedia")
    val image : MovieImageDto
)

fun List<MovieDto>.asDomainModel () : List<MovieModel>{
    return map{
        MovieModel(
            title = it.title,
            description = it.shortReview,
            image = it.image.imageURL
        )
    }
}
