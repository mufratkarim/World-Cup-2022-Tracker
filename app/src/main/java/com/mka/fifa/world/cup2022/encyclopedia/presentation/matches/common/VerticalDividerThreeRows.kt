package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun VerticalDividerThreeRows(
    title1: String,
    title2: String,
    title3: String,
    screenSize1: Float,
    screenSize2: Float,
    screenSize3: Float,
    style: TextStyle,
    color1: Color,
    color2: Color,
    color3: Color,
    dividerColor: Color,
    padding: Int,
    height: IntrinsicSize = IntrinsicSize.Min

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(Color.DarkGray.copy(alpha = 0.6f)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MatchesByIdScreenText(title1, screenSize1, style, color1, padding)
        VerticalDivider(dividerColor)
        MatchesByIdScreenText(title2, screenSize2, style, color2, padding)
        VerticalDivider(dividerColor)
        MatchesByIdScreenText(title3, screenSize3, style, color3, padding)

    }
}