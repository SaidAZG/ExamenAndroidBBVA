package com.example.examenandroidbbva.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenandroidbbva.domain.usecase.ClearSavedDataUseCase
import com.example.examenandroidbbva.domain.usecase.GetImageUseCase
import com.example.examenandroidbbva.domain.usecase.GetSavedDataUseCase
import com.example.examenandroidbbva.domain.usecase.SessionStatusUseCase
import com.example.examenandroidbbva.ui.screens.dashboard.state.DashboardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getSavedDataUseCase: GetSavedDataUseCase,
    private val sessionStatusUseCase: SessionStatusUseCase,
    private val clearSavedDataUseCase: ClearSavedDataUseCase,
    private val getImageUseCase: GetImageUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state

    init{
        viewModelScope.launch {
            getImage()
            val savedData = getSavedDataUseCase()
            if (savedData != null) {
                _state.value = _state.value.copy(userData = savedData)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            sessionStatusUseCase(false)
            clearSavedDataUseCase()
            _state.value = _state.value.copy(logout = true)
        }
    }

    private fun getImage(){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val response = getImageUseCase()

            if (response.isSuccessful) {
                val imageResponse = response.body()
                if (imageResponse != null) {
                    _state.value = _state.value.copy(profileImageUrl = imageResponse.message)
                }
            } else {
                _state.value = _state.value.copy(errorMessage = response.message())
            }
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}