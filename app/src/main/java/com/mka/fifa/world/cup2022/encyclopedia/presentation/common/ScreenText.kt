package com.mka.fifa.world.cup2022.encyclopedia.presentation.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenText(
    title: String,
    screenSize: Float,
    padding: Int,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.White,
    textAlign: TextAlign = TextAlign.Center,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = title,
        color = color,
        modifier = Modifier
            .fillMaxSize(screenSize)
            .padding(top = padding.dp),
        textAlign = textAlign,
        fontFamily = FontFamily.Default,
        fontWeight = fontWeight,
        fontSize = 15.sp,
        style = style
    )
}