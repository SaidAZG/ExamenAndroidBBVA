package com.example.examenandroidbbva.domain.usecase

import com.example.examenandroidbbva.data.remote.model.ImageResponse
import com.example.examenandroidbbva.domain.repository.ImageRepository
import retrofit2.Response
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val imageRepository: ImageRepository) {
    suspend operator fun invoke(): Response<ImageResponse> {
        return imageRepository.getImage()
    }
}