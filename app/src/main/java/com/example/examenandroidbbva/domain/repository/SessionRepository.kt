package com.example.examenandroidbbva.domain.repository

interface SessionRepository {
    fun isLoggedIn(): Boolean
    fun setUserLoggedIn(isLoggedIn: Boolean)
}