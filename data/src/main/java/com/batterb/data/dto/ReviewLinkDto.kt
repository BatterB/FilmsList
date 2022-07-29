package com.batterb.data.dto

import com.google.gson.annotations.SerializedName

data class ReviewLinkDto (
    @SerializedName("type")
    val type : String,

    @SerializedName("url")
    val url : String,

    @SerializedName("suggested_link_text")
    val suggestLinkText : String
)