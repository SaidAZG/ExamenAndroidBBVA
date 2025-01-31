package com.example.examenandroidbbva.data.api

import com.example.examenandroidbbva.data.api.bodies.LoginRequest
import com.example.examenandroidbbva.data.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLoginService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}