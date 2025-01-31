package com.example.examenandroidbbva.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.examenandroidbbva.ui.theme.DarkBlue
import com.example.examenandroidbbva.ui.theme.NavyBlue
import com.example.examenandroidbbva.ui.theme.Transparent
import com.example.examenandroidbbva.ui.theme.White

@Preview
@Composable
fun BasicTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = {},
){
    OutlinedTextField(
        modifier = modifier,
        value = value,
        label = { Text(label) },
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        textStyle = TextStyle(color = DarkBlue),
        colors = TextFieldDefaults.colors(
            focusedTextColor = DarkBlue,
            unfocusedTextColor = DarkBlue,
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            focusedLabelColor = DarkBlue,
            unfocusedLabelColor = DarkBlue,
            cursorColor = NavyBlue
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
}