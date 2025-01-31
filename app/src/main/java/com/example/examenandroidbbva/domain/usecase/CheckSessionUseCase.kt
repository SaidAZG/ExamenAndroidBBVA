package com.example.examenandroidbbva.domain.usecase

import com.example.examenandroidbbva.domain.repository.SessionRepository
import javax.inject.Inject

class CheckSessionUseCase @Inject constructor(
    private val repository: SessionRepository
){
    operator fun invoke(): Boolean {
        return repository.isLoggedIn()
    }
}