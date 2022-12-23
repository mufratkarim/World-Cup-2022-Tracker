package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

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
    padding: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(Color.DarkGray.copy(alpha = 0.6f)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MatchesByIdScreenText(title1, screenSize1, style1, color1, padding)
        VerticalDivider(dividerColor)
        MatchesByIdScreenText(title2, screenSize2, style2, color2, padding)
    }
}