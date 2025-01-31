package com.example.examenandroidbbva.domain.usecase

import com.example.examenandroidbbva.domain.repository.SessionRepository
import javax.inject.Inject

class ClearSavedDataUseCase @Inject constructor(
    private val repository: SessionRepository
){
    operator fun invoke(){
        return repository.clearLoginResponse()
    }
}