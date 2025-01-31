package com.example.examenandroidbbva.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenandroidbbva.data.api.bodies.LoginRequest
import com.example.examenandroidbbva.domain.usecase.LoginUseCase
import com.example.examenandroidbbva.domain.usecase.SaveDataUseCase
import com.example.examenandroidbbva.domain.usecase.SessionStatusUseCase
import com.example.examenandroidbbva.ui.screens.login.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val setSessionStatusUseCase: SessionStatusUseCase,
    private val savedDataUseCase: SaveDataUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onEmailChanged(newValue: String) {
        _state.value = _state.value.copy(email = newValue)
        validateFields()
    }

    fun onPasswordChanged(newValue: String) {
        _state.value = _state.value.copy(password = newValue)
        validateFields()
    }

    private fun validateFields() {
        _state.value = _state.value.copy(
            isLoginEnabled = _state.value.email.isNotBlank()
                    && _state.value.password.isNotBlank()
        )
    }


    fun login() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val response = loginUseCase(
                LoginRequest(_state.value.username, _state.value.email, _state.value.password)
            )
            if (response.isSuccessful) {
                setSessionStatusUseCase(true)
                savedDataUseCase(response.body()!!)
                _state.value = _state.value.copy(user = response.body(), isLoading = false)
            } else {
                _state.value = _state.value.copy(errorMessage = "Error en el login", isLoading = false)
            }
        }
    }

}