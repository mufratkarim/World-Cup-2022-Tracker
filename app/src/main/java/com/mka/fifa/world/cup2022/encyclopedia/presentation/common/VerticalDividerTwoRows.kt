package com.mka.fifa.world.cup2022.encyclopedia.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun VerticalDividerTwoRows(
    title1: String,
    title2: String,
    screenSize1: Float,
    screenSize2: Float,
    style1: TextStyle,
    style2: TextStyle,
    color1: Color,
    color2: Color,
    dividerColor: Color,
    padding: Int,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(Color.DarkGray.copy(alpha = 0.6f)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ScreenText(title1, screenSize1, padding, style = style1, color = color1, fontWeight = fontWeight)
        VerticalDivider(dividerColor)
        ScreenText(title2, screenSize2, padding, style = style2, color = color2, fontWeight = fontWeight)
    }
}