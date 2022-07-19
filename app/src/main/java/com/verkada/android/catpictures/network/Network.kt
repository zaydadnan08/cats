package com.verkada.android.catpictures.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private const val ROOT_URL = "https://api.unsplash.com/"
    private const val ACCESS_KEY = "zh8f_008JX-vvcFx0SvxUnqo-PP9au5uBXMW0iVQiH4"

    private val httpClientBuilder = OkHttpClient
        .Builder()
        .addInterceptor {
            val request = it.request()
                .newBuilder()
                .addHeader("Authorization", "Client-ID $ACCESS_KEY")
                .build()
            it.proceed(request)
        }

    val service: PictureService =
        Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .client(httpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PictureService::class.java)
}
