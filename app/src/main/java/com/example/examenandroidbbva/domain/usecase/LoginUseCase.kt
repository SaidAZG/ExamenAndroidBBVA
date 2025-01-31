package com.example.examenandroidbbva.domain.usecase

import com.example.examenandroidbbva.data.api.bodies.LoginRequest
import com.example.examenandroidbbva.data.remote.model.LoginResponse
import com.example.examenandroidbbva.domain.repository.LoginRespository
import retrofit2.Response
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRespository) {
    suspend operator fun invoke(request: LoginRequest): Response<LoginResponse> {
        return loginRepository.login(request)
    }
}