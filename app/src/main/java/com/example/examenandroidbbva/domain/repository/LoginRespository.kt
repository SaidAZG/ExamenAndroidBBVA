package com.example.examenandroidbbva.domain.repository

import com.example.examenandroidbbva.data.api.bodies.LoginRequest
import com.example.examenandroidbbva.data.remote.model.LoginResponse
import retrofit2.Response

interface LoginRespository {
    suspend fun login(request: LoginRequest): Response<LoginResponse>
}