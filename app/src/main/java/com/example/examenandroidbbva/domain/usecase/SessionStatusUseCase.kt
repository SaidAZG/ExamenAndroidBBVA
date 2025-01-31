package com.example.examenandroidbbva.domain.usecase

import com.example.examenandroidbbva.domain.repository.SessionRepository
import javax.inject.Inject

class SessionStatusUseCase@Inject constructor(
    private val repository: SessionRepository
){
    operator fun invoke(isLoggedIn: Boolean) {
        return repository.setUserLoggedIn(isLoggedIn)
    }
}