package com.example.examenandroidbbva.ui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.examenandroidbbva.ui.screens.dashboard.DASHBOARD_SCREEN
import com.example.examenandroidbbva.ui.screens.dashboard.DashboardScreen
import com.example.examenandroidbbva.ui.screens.login.LOGIN_SCREEN
import com.example.examenandroidbbva.ui.screens.login.LoginScreen
import com.example.examenandroidbbva.ui.screens.splash.SPLASH_SCREEN
import com.example.examenandroidbbva.ui.screens.splash.SplashScreen

@Composable
fun MainActivityNavigation(navController : NavHostController) {
    NavHost(
        modifier = Modifier.padding(
            WindowInsets.statusBars.asPaddingValues()
        ),
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        composable(SPLASH_SCREEN) {
            SplashScreen(
                isLoggedIn = true,
                goToLogin = {
                    navController.navigate(LOGIN_SCREEN) {
                        popUpTo(SPLASH_SCREEN) { inclusive = true }
                    }
                },
                goToDashboard = {
                    navController.navigate(DASHBOARD_SCREEN) {
                        popUpTo(SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }
        composable(LOGIN_SCREEN) { LoginScreen() }
        composable(DASHBOARD_SCREEN) { DashboardScreen() }
    }
}