package com.mka.fifa.world.cup2022.encyclopedia.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalDividerThreeRows(
    title1: String,
    title2: String,
    title3: String,
    screenSize1: Float,
    screenSize2: Float,
    screenSize3: Float,
    style: TextStyle,
    style2: TextStyle = TextStyle.Default,
    style3: TextStyle = TextStyle.Default,
    color1: Color,
    color2: Color,
    color3: Color,
    dividerColor: Color,
    height: Dp = 55.dp,
    padding: Int,
    textDecoration: TextDecoration = TextDecoration.None,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(Color.DarkGray.copy(alpha = 0.6f)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
    ) {
        ScreenText(title1, screenSize1, padding, style =  style, color =  color1, fontWeight = fontWeight, textDecoration = textDecoration)
        VerticalDivider(dividerColor)
        ScreenText(title2, screenSize2, padding, style =  style2, color =  color2, fontWeight = fontWeight, textDecoration = textDecoration)
        VerticalDivider(dividerColor)
        ScreenText(title3, screenSize3, padding, style =  style3, color =  color3, fontWeight = fontWeight, textDecoration = textDecoration)

    }
}