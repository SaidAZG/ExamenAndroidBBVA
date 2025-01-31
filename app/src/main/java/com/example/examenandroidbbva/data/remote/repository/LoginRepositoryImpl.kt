package com.example.examenandroidbbva.data.remote.repository

import com.example.examenandroidbbva.data.api.ApiLoginService
import com.example.examenandroidbbva.data.api.bodies.LoginRequest
import com.example.examenandroidbbva.data.remote.model.LoginResponse
import com.example.examenandroidbbva.domain.repository.LoginRespository
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiLoginService: ApiLoginService
) : LoginRespository {
    override suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return apiLoginService.login(request)
    }
}