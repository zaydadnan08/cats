package com.verkada.android.catpictures.data

import com.google.gson.annotations.SerializedName

data class PictureResponse(
    @SerializedName("results")
    val pictures: List<Picture>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)
