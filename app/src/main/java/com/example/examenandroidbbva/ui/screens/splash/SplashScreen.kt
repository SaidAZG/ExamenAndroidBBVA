package com.example.examenandroidbbva.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay

const val SPLASH_SCREEN = "splash_screen"

@Composable
fun SplashScreen(
    goToLogin: () -> Unit,
    goToDashboard: () -> Unit
) {
    val viewModel : SplashViewModel = hiltViewModel()
    val isLoggedIn = viewModel.isLoggedIn.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.checkSession()
        delay(2000)
        if (isLoggedIn.value) {
            goToDashboard()
        } else {
            goToLogin()
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}