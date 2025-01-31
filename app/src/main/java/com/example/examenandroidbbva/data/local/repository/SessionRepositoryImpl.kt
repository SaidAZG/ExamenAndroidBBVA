package com.example.examenandroidbbva.data.local.repository

import com.example.examenandroidbbva.data.local.PreferenceManager
import com.example.examenandroidbbva.data.remote.model.LoginResponse
import com.example.examenandroidbbva.domain.repository.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val preferenceManager: PreferenceManager
): SessionRepository {

    override fun isLoggedIn(): Boolean {
        return preferenceManager.isLoggedIn()
    }

    override fun setUserLoggedIn(isLoggedIn: Boolean) {
        preferenceManager.setUserLoggedIn(isLoggedIn)
    }

    override fun saveLoginResponse(loginResponse: LoginResponse) {
        preferenceManager.saveLoginResponse(loginResponse)
    }

    override fun getLoginResponse(): LoginResponse? {
        return preferenceManager.getLoginResponse()
    }

    override fun clearLoginResponse() {
        preferenceManager.clearLoginResponse()
    }
}