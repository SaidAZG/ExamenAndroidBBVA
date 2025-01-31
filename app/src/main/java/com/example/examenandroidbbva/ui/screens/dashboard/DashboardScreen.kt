package com.example.examenandroidbbva.ui.screens.dashboard

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.examenandroidbbva.ui.components.BasicButton
import com.example.examenandroidbbva.ui.components.BasicTextView
import com.example.examenandroidbbva.ui.theme.LightBlue
import com.example.examenandroidbbva.ui.theme.NavyBlue

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
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center){
            if (state.isLoading){
                CircularProgressIndicator()
                Text("Cargando...")
            }else{
                AsyncImage(
                    model = state.profileImageUrl,
                    contentDescription = "Imagen desde URL",
                    modifier = Modifier.fillMaxWidth(.7f).aspectRatio(1f).clip(
                        shape = androidx.compose.foundation.shape.CircleShape
                    ).border(
                        width = 5.dp,
                        color = LightBlue,
                        shape = androidx.compose.foundation.shape.CircleShape
                    ),
                    contentScale = ContentScale.FillBounds,
                    placeholder = null
                )
                state.errorMessage?.let {
                    Text(it, color = Color.Red)
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            BasicTextView(
                text = "Bienvenido ${state.userData?.name} ${state.userData?.lastName}"
            )
            BasicTextView(
                modifier = Modifier.padding(8.dp),
                text = "ID: ${state.userData?.id}"
            )
            BasicTextView(
                text = "Edad: ${state.userData?.age}"
            )
            BasicTextView(
                modifier = Modifier.padding(8.dp),
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
}