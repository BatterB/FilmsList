package com.batterb.data.dto

import com.google.gson.annotations.SerializedName

data class MovieImageDto (

    @SerializedName("type")
    val type : String,

    @SerializedName("src")
    val imageURL : String,

    @SerializedName("width")
    val imageWidth : Int,

    @SerializedName("height")
    val imageHeight : Int
)