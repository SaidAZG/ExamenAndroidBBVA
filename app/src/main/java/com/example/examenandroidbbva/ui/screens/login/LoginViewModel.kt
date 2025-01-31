package com.example.examenandroidbbva.ui.screens.login

import androidx.lifecycle.ViewModel
import com.example.examenandroidbbva.ui.screens.login.state.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {
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

}