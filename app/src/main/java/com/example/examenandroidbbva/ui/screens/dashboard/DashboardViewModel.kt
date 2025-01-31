package com.example.examenandroidbbva.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenandroidbbva.domain.usecase.ClearSavedDataUseCase
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
) : ViewModel() {
    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state

    init{
        viewModelScope.launch {
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
}