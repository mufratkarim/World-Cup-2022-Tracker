package com.mka.fifa.world.cup2022.encyclopedia.presentation.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ButtonText(title: String, style: TextStyle, color: Color) {
    Text(
        text = title,
        style = style,
        color = color,
        overflow = TextOverflow.Ellipsis,
        textDecoration = TextDecoration.Underline,
        fontFamily = FontFamily.Monospace
    )
}