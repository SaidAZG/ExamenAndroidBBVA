package com.example.examenandroidbbva.ui.screens.dashboard.state

import com.example.examenandroidbbva.data.remote.model.LoginResponse

data class DashboardState(
    val userData: LoginResponse? = null,
    val profileImageUrl: String? = null,
    val errorMessage: String? = null,
    val logout: Boolean = false
)
