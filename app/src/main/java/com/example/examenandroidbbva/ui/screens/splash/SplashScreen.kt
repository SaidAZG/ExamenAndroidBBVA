package com.example.examenandroidbbva.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

const val SPLASH_SCREEN = "splash_screen"

@Composable
fun SplashScreen(
    isLoggedIn: Boolean,
    goToLogin: () -> Unit,
    goToDashboard: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000)
        if (isLoggedIn) {
            goToDashboard()
        } else {
            goToLogin()
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}