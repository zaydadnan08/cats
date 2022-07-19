package com.verkada.android.catpictures.data


import com.google.gson.annotations.SerializedName

data class Picture (
    @SerializedName("id")
    val id: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("urls")
    val urls: Urls,
)


data class Urls(
    @SerializedName("regular")
    val regular: String,
)
