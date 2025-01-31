package com.example.examenandroidbbva.domain.usecase

import com.example.examenandroidbbva.data.remote.model.LoginResponse
import com.example.examenandroidbbva.domain.repository.SessionRepository
import javax.inject.Inject

class GetSavedDataUseCase @Inject constructor(
    private val repository: SessionRepository
){
    operator fun invoke(): LoginResponse? {
        return repository.getLoginResponse()
    }
}