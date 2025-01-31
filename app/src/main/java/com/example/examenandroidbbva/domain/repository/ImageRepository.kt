package com.example.examenandroidbbva.domain.repository

import com.example.examenandroidbbva.data.remote.model.ImageResponse
import retrofit2.Response

interface ImageRepository {
    suspend fun getImage(): Response<ImageResponse>
}