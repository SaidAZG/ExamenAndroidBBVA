package com.example.examenandroidbbva.domain.usecase

import com.example.examenandroidbbva.data.remote.model.LoginResponse
import com.example.examenandroidbbva.domain.repository.SessionRepository
import javax.inject.Inject

class SaveDataUseCase @Inject constructor(
    private val repository: SessionRepository
){
    operator fun invoke(savedData: LoginResponse){
        return repository.saveLoginResponse(savedData)
    }
}