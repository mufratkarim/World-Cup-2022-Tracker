package com.mka.fifa.world.cup2022.encyclopedia.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Heading(
    title1: String,
    title2: String,
    title3: String,
    backgroundColor: Color,
    screenSize1: Float,
    screenSize2: Float,
    screenSize3: Float,
    padding: Int,
    color: Color,
    style: TextStyle,
    textAlign1: TextAlign = TextAlign.Start,
    textAlign2: TextAlign = TextAlign.Center,
    textAlign3: TextAlign = TextAlign.Center
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {

        ScreenText(
            title = title1,
            screenSize = screenSize1,
            padding = padding,
            color = color,
            style = style,
            fontWeight = FontWeight.Bold,
            textAlign = textAlign1
        )

        ScreenText(
            title = title2,
            screenSize = screenSize2,
            color = color,
            style = style,
            padding = padding,
            fontWeight = FontWeight.Bold,
            textAlign = textAlign2
        )

        ScreenText(
            title = title3,
            screenSize = screenSize3,
            color = color,
            style = style,
            padding = padding,
            fontWeight = FontWeight.Bold,
            textAlign = textAlign3
        )

    }
}