package com.example.examenandroidbbva.ui.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.examenandroidbbva.ui.components.BasicButton
import com.example.examenandroidbbva.ui.components.BasicTextView

const val DASHBOARD_SCREEN = "dashboard_screen"

@Composable
fun DashboardScreen(
    goToLogin : () -> Unit = {}
) {
    val viewModel : DashboardViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.logout){
        if (state.logout) goToLogin()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextView(
            text = "Bienvenido ${state.userData?.name} ${state.userData?.lastName}"
        )
        BasicTextView(
            text = "ID: ${state.userData?.id}"
        )
        BasicTextView(
            text = "Edad: ${state.userData?.age}"
        )
        BasicTextView(
            text = "Género: ${state.userData?.gender}"
        )
        BasicButton(
            onClick = {
                viewModel.logout()
            },
            text = "Cerrar Sesión"
        )
    }
}