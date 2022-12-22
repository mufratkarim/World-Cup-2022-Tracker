package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatchesScreenText(title: String, screenSize: Float, padding: Int, fontWeight: FontWeight) {
    Text(
        text = title,
        color = Color.White,
        modifier = Modifier
            .fillMaxSize(screenSize)
            .padding(top = padding.dp),
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Serif,
        fontWeight = fontWeight,
        fontSize = 15.sp
    )
}