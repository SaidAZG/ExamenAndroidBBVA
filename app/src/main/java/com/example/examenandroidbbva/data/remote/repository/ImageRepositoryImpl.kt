package com.example.examenandroidbbva.data.remote.repository

import com.example.examenandroidbbva.data.api.ApiImageService
import com.example.examenandroidbbva.data.remote.model.ImageResponse
import com.example.examenandroidbbva.domain.repository.ImageRepository
import retrofit2.Response
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val apiImageService: ApiImageService
) : ImageRepository {
    override suspend fun getImage(): Response<ImageResponse> {
        return apiImageService.getRandomImage()
    }
}