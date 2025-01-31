package com.example.examenandroidbbva.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.examenandroidbbva.ui.theme.DarkBlue

@Preview(showBackground = true)
@Composable
fun BasicTextView(
    text: String = "Hola",
    fontSize: TextUnit = 18.sp,
    color: Color = DarkBlue,
    fontWeight: FontWeight = FontWeight.Bold,
    allCaps: Boolean = false,
    modifier: Modifier = Modifier
){
    Text(
        modifier = modifier,
        text = if (allCaps) text.uppercase() else text,
        color = color,
        fontWeight = fontWeight,
        fontSize = fontSize
    )
}