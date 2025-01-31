package com.example.examenandroidbbva.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.examenandroidbbva.ui.theme.Blue
import com.example.examenandroidbbva.ui.theme.GreyBlue
import com.example.examenandroidbbva.ui.theme.White

@Preview
@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String = "Hola",
    onClick: () -> Unit = {},
){
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue,
            disabledContainerColor = GreyBlue
        ),
        onClick = { /*TODO*/ },
        enabled = enabled
    ){
        Text(
            text = text.uppercase(),
            color = White
        )
    }
}