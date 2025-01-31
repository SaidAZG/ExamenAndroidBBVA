package com.example.examenandroidbbva.ui.screens.login.state

import com.example.examenandroidbbva.data.remote.model.LoginResponse

data class LoginState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val isLoginEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val user: LoginResponse? = null,
    val errorMessage: String? = null
)
