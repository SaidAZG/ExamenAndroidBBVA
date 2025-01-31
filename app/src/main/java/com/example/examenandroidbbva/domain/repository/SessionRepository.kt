package com.example.examenandroidbbva.domain.repository

import com.example.examenandroidbbva.data.remote.model.LoginResponse

interface SessionRepository {
    fun isLoggedIn(): Boolean
    fun setUserLoggedIn(isLoggedIn: Boolean)
    fun saveLoginResponse(loginResponse: LoginResponse)
    fun getLoginResponse(): LoginResponse?
    fun clearLoginResponse()
}