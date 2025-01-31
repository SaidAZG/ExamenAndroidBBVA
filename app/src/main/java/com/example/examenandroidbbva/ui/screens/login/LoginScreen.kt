package com.example.examenandroidbbva.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.examenandroidbbva.ui.components.BasicButton
import com.example.examenandroidbbva.ui.components.BasicTextField

const val LOGIN_SCREEN = "login_screen"

@Composable
fun LoginScreen(
    goToDasboard : () -> Unit = {}
){
    val viewModel : LoginViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.user){
        if (state.user != null){
            goToDasboard()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = state.email,
            label = "Correo electrónico",
            onValueChange = { viewModel.onEmailChanged(it) },
        )
        BasicTextField(
            modifier = Modifier.padding(vertical = 12.dp),
            value = state.password,
            label = "Contraseña",
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { viewModel.onPasswordChanged(it) },
        )
        BasicButton(
            onClick = {
                viewModel.login()
            },
            text = "Iniciar Sesión",
            enabled = state.isLoginEnabled
        )

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.errorMessage?.let {
            Text(it, color = Color.Red)
        }
    }
}