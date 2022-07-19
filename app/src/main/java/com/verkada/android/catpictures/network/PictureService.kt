package com.verkada.android.catpictures.network

import com.verkada.android.catpictures.data.PictureResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureService {

    @GET("/search/photos?query=cat")
    suspend fun catPictures(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = PER_PAGE_COUNT
    ): PictureResponse

    @GET("/search/photos?query=bird")
    suspend fun birdPictures(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = PER_PAGE_COUNT
    ): PictureResponse

    companion object {
        private const val PER_PAGE_COUNT = 30
    }
}
