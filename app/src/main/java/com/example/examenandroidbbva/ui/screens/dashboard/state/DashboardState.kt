package com.example.examenandroidbbva.ui.screens.dashboard.state

import com.example.examenandroidbbva.data.remote.model.LoginResponse

data class DashboardState(
    val userData: LoginResponse? = null,
    val isLoading: Boolean = false,
    val profileImageUrl: String? = null,
    val errorMessage: String? = null,
    val logout: Boolean = false
)
