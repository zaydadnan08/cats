package com.verkada.android.catpictures.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private const val ROOT_URL = "https://picsum.photos/v2/"

    private val httpClientBuilder = OkHttpClient
        .Builder()
        .addInterceptor {
            val request = it.request()
                .newBuilder()
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
