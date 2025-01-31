package com.example.examenandroidbbva.data.api

import com.example.examenandroidbbva.data.remote.model.ImageResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiImageService {
    @GET("image/random")
    suspend fun getRandomImage(): Response<ImageResponse>

}